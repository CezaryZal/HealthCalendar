package com.CezaryZal.authentication.manager.filter;

import com.CezaryZal.constants.AuthenticationConstants;
import io.jsonwebtoken.*;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

@Slf4j
public class JwtFilter extends BasicAuthenticationFilter {

    public JwtFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        UsernamePasswordAuthenticationToken authenticationByToken = getAuthenticationByToken(request);
        if (authenticationByToken == null) {
            chain.doFilter(request, response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(authenticationByToken);
        //po pomyślnej autoryzacji filter przekazuje rządanie dalej
        chain.doFilter(request, response);
    }

    //Szyfrownianie symetryczne
    private UsernamePasswordAuthenticationToken getAuthenticationByToken(HttpServletRequest request) {
        String token = request.getHeader(AuthenticationConstants.TOKEN_HEADER);
        if (StringUtils.isNotEmpty(token) && token.startsWith(AuthenticationConstants.TOKEN_PREFIX)) {
            try {
                Jws<Claims> claimsJws = Jwts
                        .parser()
                        .setSigningKey(AuthenticationConstants.SECRET_KEY.getBytes())
                        .parseClaimsJws(token.replace(AuthenticationConstants.TOKEN_PREFIX, ""));
                String subject = claimsJws.getBody().getSubject();
                String userName = claimsJws.getBody().get(AuthenticationConstants.NAME_KEY).toString();
                String role = claimsJws.getBody().get(AuthenticationConstants.ROLES_KEY).toString();

                Set<SimpleGrantedAuthority> simpleGrantedAuthorities = Collections.singleton(new SimpleGrantedAuthority(role));

                if (StringUtils.isNotEmpty(userName)) {
                    return new UsernamePasswordAuthenticationToken(userName, null, simpleGrantedAuthorities);
                }
            } catch (ExpiredJwtException exception) {
                log.warn("Request to parse expired JWT : {} failed : {}", token, exception.getMessage());
            } catch (UnsupportedJwtException exception) {
                log.warn("Request to parse unsupported JWT : {} failed : {}", token, exception.getMessage());
            } catch (MalformedJwtException exception) {
                log.warn("Request to parse invalid JWT : {} failed : {}", token, exception.getMessage());
            } catch (SignatureException exception) {
                log.warn("Request to parse JWT with invalid signature : {} failed : {}", token, exception.getMessage());
            } catch (IllegalArgumentException exception) {
                log.warn("Request to parse empty or null JWT : {} failed : {}", token, exception.getMessage());
            }
        }
        return null;
    }

}

package com.CezaryZal.security;

import com.CezaryZal.user.login.LoginService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

public class JwtFilter extends BasicAuthenticationFilter {

    private LoginService loginService;

    public JwtFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader("Authorization");
        UsernamePasswordAuthenticationToken authResult = getAuthenticationByToken (header);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        //po pomyślnej autoryzacji filter przekazuje rządanie dalej
        chain.doFilter(request, response);
    }

    //Szyfrownianie symetryczne
    private UsernamePasswordAuthenticationToken getAuthenticationByToken(String header) {
        Jws<Claims> claimsJws = Jwts
                .parser()
                .setSigningKey("dFKYX}&[K;'{{;q".getBytes())
                .parseClaimsJws(header.replace("Bearer ", ""));

        String userName = claimsJws.getBody().get("name").toString();
        String role = claimsJws.getBody().get("role").toString();
//        Long userId = Long.valueOf(claimsJws.getBody().get("userId").toString());

//        loginService.setLoginName(userName);
//        loginService.setUserId(userId);

        Set<SimpleGrantedAuthority> simpleGrantedAuthorities = Collections.singleton(new SimpleGrantedAuthority(role));

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userName, null, simpleGrantedAuthorities);
        return usernamePasswordAuthenticationToken;
    }

//        public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//        Authentication authentication = authenticationManager.authenticate(authenticationToken);
//
//        if (authentication.isAuthenticated()) {
//            String jwt = jwtBuilder.build(authentication, AuthenticationConstants.JWT_EXPIRE_IN_MINUTES);
//
//            RefreshToken refreshToken = refreshTokenService.buildRefreshToken(authentication, AuthenticationConstants.REFRESH_TOKEN_EXPIRE_IN_MINUTES);
//            refreshTokenService.addToken(refreshToken);
//
//            return new AuthenticationResponse(jwt, refreshToken.getValue());
//        }
//        throw new LoginException("Invalid username or password");
//    }
}

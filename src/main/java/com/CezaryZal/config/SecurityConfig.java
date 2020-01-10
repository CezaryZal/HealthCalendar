package com.CezaryZal.config;

import com.CezaryZal.authentication.JwtFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // protection against attack from outside clients - disable
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtFilter(authenticationManager()))
                .authorizeRequests()
                .antMatchers("/test/non/**").permitAll()
                .antMatchers("/test/token/**").authenticated()
                .antMatchers("/swagger-ui.html/**").permitAll()
                .antMatchers("/login").authenticated()
                .antMatchers(HttpMethod.GET, "/api/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/actuator/**").hasRole("ADMIN");
//                .antMatchers("/test/**").hasAuthority("ACCESS_TEST")


    }
}

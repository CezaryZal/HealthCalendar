package com.CezaryZal.config;

import com.CezaryZal.authentication.JwtFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers(HttpMethod.GET, "/api/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/actuator/**").hasRole("ADMIN")
//                .antMatchers("/test/**").hasAuthority("ACCESS_TEST")
                .antMatchers("/login").authenticated()
                .antMatchers("/test/**").permitAll()
                .antMatchers("/swagger-ui.html/**").permitAll()
                .and()
                .addFilter(new JwtFilter(authenticationManager()));
//                .and()
//                // protection against attack from outside clients - disable
//                .csrf().disable();
    }
}

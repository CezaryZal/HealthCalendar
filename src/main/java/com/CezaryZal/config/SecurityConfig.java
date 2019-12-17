package com.CezaryZal.config;

import com.CezaryZal.security.JwtFilter;
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
                .antMatchers("/test/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/login").permitAll()
                .and()
                .addFilter(new JwtFilter(authenticationManager()));
//                .and()
//                .formLogin().permitAll()
//                .and()
//                //{default URL}/logout - spring logout from actual role
//                .logout().permitAll()
//                .and()
//                //allow app to use http basic - login through username and password (e.g. Postman)
//                .httpBasic()
//                .and()
//                // protection against attack from outside clients - disable
//                .csrf().disable();
    }
}

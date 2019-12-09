package com.CezaryZal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("user123")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin123")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails viewer = User.withDefaultPasswordEncoder()
//                .username("viewer")
//                .password("viewer123")
//                .roles("VIEWER")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin, viewer);
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder()
                        .encode("admin123"))
                .roles("ADMIN");
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder()
                        .encode("user123"))
                .roles("USER");
        auth.inMemoryAuthentication()
                .withUser("viewer")
                .password(passwordEncoder()
                        .encode("viewer123"))
                .roles("VIEWER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("USER", "ADMIN")
                .antMatchers( "/**").hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                //{default URL}/logout - spring logout from actual role
                .logout().permitAll()
                .and()
                //allow app to use http basic - login through username and password (e.g. Postman)
                .httpBasic()
                .and()
                // protection against attack from outside clients
                .csrf().disable();

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

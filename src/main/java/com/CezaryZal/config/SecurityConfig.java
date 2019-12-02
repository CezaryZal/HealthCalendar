package com.CezaryZal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user123")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();

        UserDetails viewer = User.withDefaultPasswordEncoder()
                .username("viewer")
                .password("viewer123")
                .roles("VIEWER")
                .build();
        return new InMemoryUserDetailsManager(user, admin, viewer);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").hasAnyRole("USER", "VIEWER")
                .antMatchers(HttpMethod.POST, "/").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/").hasRole("USER")
                .anyRequest().hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                //"home/logout - spring logout from actual role
                .logout().permitAll()
                .and()
                .csrf().disable();

    }

}

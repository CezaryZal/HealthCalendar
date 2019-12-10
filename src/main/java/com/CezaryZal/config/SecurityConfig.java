package com.CezaryZal.config;

import com.CezaryZal.user.security.UserPrincipalDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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

    private UserPrincipalDetailsService userPrincipalDetailsService;
    private PasswordEncoder passwordEncoder;

    public SecurityConfig(UserPrincipalDetailsService userPrincipalDetailsService, PasswordEncoder passwordEncoder) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

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
        auth.authenticationProvider(authenticationProvider());

//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordEncoder()
//                        .encode("admin123"))
//                .authorities("ACCESS_TEST","ROLE_ADMIN");
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password(passwordEncoder()
//                        .encode("user123"))
//                .authorities("ACCESS_TEST","ROLE_MANAGER");
//        auth.inMemoryAuthentication()
//                .withUser("viewer")
//                .password(passwordEncoder()
//                        .encode("viewer123"))
//                .roles("VIEWER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/actuator/**").hasRole("ADMIN")
                .antMatchers("/test/**").hasAuthority("ACCESS_TEST")
                .and()
                .formLogin().permitAll()
                .and()
                //{default URL}/logout - spring logout from actual role
                .logout().permitAll()
                .and()
                //allow app to use http basic - login through username and password (e.g. Postman)
                .httpBasic()
                .and()
                // protection against attack from outside clients - disable
                .csrf().disable();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

        return daoAuthenticationProvider;
    }

}

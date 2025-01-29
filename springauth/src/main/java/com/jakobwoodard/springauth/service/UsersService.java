package com.jakobwoodard.springauth.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = 
            User.withDefaultPasswordEncoder()
                .username("username")
                .password("password")
                .roles("USER")
                .build();
        UserDetails user2 = 
            User.withDefaultPasswordEncoder()
                .username("root")
                .password("admin")
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
    
}

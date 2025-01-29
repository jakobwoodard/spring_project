package com.jakobwoodard.springauth.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = 
            User.withUsername("username")
                .password("{bcrypt}" + passwordEncoder.encode("password"))
                .roles("USER")
                .build();
        UserDetails user2 = 
            User.withUsername("root")
                .password("{bcrypt}" + passwordEncoder.encode("admin"))
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
    
}

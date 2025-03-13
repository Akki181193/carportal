package com.carportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

//        http.authorizeHttpRequests(req-> req.anyRequest().permitAll()).httpBasic(Customizer.withDefaults());
//
//        return http.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable).build();
        http.authorizeHttpRequests(auth-> auth.anyRequest().permitAll()).csrf(csrf-> csrf.disable()).cors(cors->cors.disable());
        return http.build();
    }
}

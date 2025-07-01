package com.trabajo.posappseguras.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers(headers -> headers
                        .contentTypeOptions(Customizer.withDefaults()) // Agrega la cabecera X-Content-Type-Options: nosniff
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::deny) // Agrega la cabecera X-Frame-Options: DENY
                        .httpStrictTransportSecurity(hstsConfig ->
                                hstsConfig.maxAgeInSeconds(31536000)
                        )
                )
                .authorizeHttpRequests(authz -> authz // Configuración de autorización de peticiones HTTP
                        .anyRequest().permitAll()
                )
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
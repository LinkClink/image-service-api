package com.example.imageserviceapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
    @Bean
    public org.springframework.security.crypto.password.PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}

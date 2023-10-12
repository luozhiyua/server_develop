package com.example.contact.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.contact"})
//@EntityScan(basePackages = {"com.example.contact"})
public class ApplicationConfig {
}

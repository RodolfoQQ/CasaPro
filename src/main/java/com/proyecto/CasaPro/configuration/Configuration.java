package com.proyecto.CasaPro.configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

@org.springframework.context.annotation.Configuration
public class Configuration {
    //@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}

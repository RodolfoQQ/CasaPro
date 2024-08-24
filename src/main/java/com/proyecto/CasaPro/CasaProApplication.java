package com.proyecto.CasaPro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CasaProApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasaProApplication.class, args);


	}
	@Bean
	public  WebMvcConfigurer webMvcConfigurer(){
		return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200")
                        .allowedMethods("*")
                        .allowedHeaders("*")
						.allowCredentials(true);
            }
        };
	}

}

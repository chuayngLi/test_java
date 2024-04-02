package com.example.demotest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOriginPatterns("http://localhost:*", "http://127.0.0.1:*", "*")
                .maxAge(300 * 1000).allowedHeaders("*").allowedMethods("*").allowCredentials(true);
    }
}
package tsenako.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                    "http://localhost:3000",      // Dev web (Angular, React, etc)
                    "http://localhost:8081",      // Dev Angular Tsenako
                    "http://localhost:8082",      // Autre port
                    "http://localhost:19000",     // Expo Metro
                    "http://localhost:19001",     // Expo Web
                    "http://127.0.0.1:*"         // Tout localhost avec n'importe quel port
                )
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);  // Cache la réponse preflight 1h
    }
}

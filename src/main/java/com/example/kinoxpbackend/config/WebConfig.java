package com.example.kinoxpbackend.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Apply CORS to all paths
                        .allowedOrigins("*")  // Allow all origins (or specify your frontend's origin)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow specific HTTP methods
                        .allowedHeaders("*")
                        .allowedOrigins("http://localhost:63342")// Allow all headers
                        .allowCredentials(false);  // Disable credentials for simplicity
            }
        };
    }
}

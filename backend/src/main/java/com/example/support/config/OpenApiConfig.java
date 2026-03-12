package com.example.support.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI supportApi() {
        return new OpenAPI()
                    .info(new Info()
                        .title("AI Support Ticket API")
                        .description("API documentation for AI-powered support ticket system")
                        .version("1.0"));
    }
}
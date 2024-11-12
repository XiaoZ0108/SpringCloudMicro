package com.example.product_service.Config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI productServiceAPI(){

        return new OpenAPI().info(new Info().title("Product Service API").description("REST API for Product Service").version("V0.1").license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation().description("REFER ME").url("http://localhost:8080/api-docs"));
    }

}

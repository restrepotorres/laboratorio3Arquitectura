package com.udea.parcialfinal.utils.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuration class for OpenAPI documentation of the API.
 * This class defines a method to configure OpenAPI documentation for the API endpoints.
 */
@Configuration
public class OpenAPIConfig {

    @Value("${hospital-api.openapi.dev-url}")
    private String devUrl;

    @Value("${hospital-api.openapi.description}")
    private String description;

    @Value("${hospital-api.openapi.contact.email}")
    private String email;

    @Value("${hospital-api.openapi.contact.name}")
    private String name;

    @Value("${hospital-api.openapi.contact.url}")
    private String url;

    @Value("${hospital-api.openapi.title}")
    private String title;

    @Value("${hospital-api.openapi.version}")
    private String version;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription(description);

        Contact contact = new Contact();
        contact.setEmail(email);
        contact.setName(name);
        contact.setUrl(url);

        License mitLicense = new License().name("MIT License").url("https://airline.com/licenses/mit/");

        Info info = new Info()
                .title(title)
                .version(version)
                .contact(contact)
                .description("Esta API expone endpoints para Historia Clinica.").termsOfService("https://www.airline.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}

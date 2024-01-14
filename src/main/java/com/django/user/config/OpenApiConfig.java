package com.django.user.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(contact = @Contact(email = "kamalrana03@gmail.com", name = "kamal mohan singh rana", url = "kamalrana.web.app"),
        description = "authorization sever api's for user authentication and client registration",
        title = "open api specification of rest api's for user authorization server",
        license = @License(name = "MIT")),
        servers = {@Server(description = "local", url = "http://127.0.0.1")}
)
@Configuration
public class OpenApiConfig {
}

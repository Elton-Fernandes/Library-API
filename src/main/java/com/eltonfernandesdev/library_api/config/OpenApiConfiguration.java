package com.eltonfernandesdev.library_api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Library API",
                version = "v1",
                contact = @Contact(
                        name = "Elton Fernandes",
                        email = "eltonfernandes.ef47@gmail.com"
                ),
                description = "API para gerenciamento de bibliotecas."
        )
)
public class OpenApiConfiguration {
}

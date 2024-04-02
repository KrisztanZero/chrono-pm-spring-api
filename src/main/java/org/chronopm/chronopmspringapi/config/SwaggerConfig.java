package org.chronopm.chronopmspringapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
        title = "Chrono PM",
        version = "1.0",
        description = "Project management application",
        contact = @Contact(
                name = "KrisztanZero",
                url = "https://github.com/KrisztanZero"
        )
))
public class SwaggerConfig {
}

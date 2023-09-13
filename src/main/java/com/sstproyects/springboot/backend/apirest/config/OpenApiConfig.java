package com.sstproyects.springboot.backend.apirest.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.sstproyects.springboot.backend.apirest.controller", "com.sstproyects.springboot.backend.apirest.models" })
@OpenAPIDefinition(
  info = @Info(
    title = "OpenAPI specification - Shalom Solution Tech",
    version = "1.0",
    description = "OpenAPI documentation for Spring Security",
    termsOfService = "Terms of service",
    contact = @Contact(
      name = "Shalom Solution Tech",
      email = "shalomsolutiontech@gmail.com",
      url = "https://localhost:8080/"
    ),
    license = @License(
      name = "Licence name",
      url = "https://some-url.com"
    )
  ),
  servers = {
    @Server(
      description = "Local ENV",
      url = "http://localhost:8080"
    ),
    @Server(
      description = "PROD ENV",
      url = "https://your-prod-url.com"
    )
  },
  security = @SecurityRequirement(
    name = "bearerAuth"
  )
)
@SecurityScheme(
  name = "bearerAuth",
  description = "JWT auth description",
  type = SecuritySchemeType.HTTP,
  scheme = "bearer",
  bearerFormat = "JWT",
  in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
  // Puedes agregar más configuración si es necesario.
  // Por ejemplo, personalizar el paquete de escaneo de controladores.
}

package com.vocaciON.vocacion_service.config;



import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;

import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration

public class OpenApiConfig {

    @Value("${vocacion.openapi.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        //Definir el servidor del desarrollo
        Server devServer = new Server();
        devServer.setUrl(this.devUrl);
        devServer.setDescription("El servidor del entorno de desarrollo");

        // Informacion de contacto
        Contact contact = new Contact();
        contact.setEmail("mauricio_favian@hotmail.com");
        contact.setName("vocaciON");
        contact.setUrl("https://vocaciON.com/");// recomendado poner el landinpage de tu pagina

        License mitLicense = new License().name("MIT License").url("https://opensource.org/licenses/MIT");

        //Informacion general del API
        Info info = new Info()
                .title("Vocaci-ON - Orientacion Vocacional")
                .version("1.0")
                .contact(contact)
                .description("API Rest Full - Venta de servicios de orientacion")
                .termsOfService("https://www.vocacion.com/terms")
                .license(mitLicense);


        //Configuracion de seguridad JWT

        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .name("BearerAuthentication");

        Components components = new Components()
                .addSecuritySchemes("bearerAuth", securityScheme);

        SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerAuth");

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer))
                .addSecurityItem(securityRequirement)
                .components(components);

    }

}







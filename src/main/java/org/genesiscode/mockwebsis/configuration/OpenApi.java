package org.genesiscode.mockwebsis.configuration;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi {

    @Bean
    public OpenAPI springShopOpenAPI() {
        Contact contact = new Contact()
                .name("Michisoft")
                .email("michosft@gmail.com");


        License license = new License()
                .name("Apache 2.0")
                .url("http://springdoc.org");

        Info info = new Info()
                .contact(contact)
                .title("Websis System")
                .description("Este sistema nos proporcionara informacion sobre los docentes")
                .version("v1")
                .license(license);

        ExternalDocumentation externalDocumentation = new ExternalDocumentation()
                .description("SpringShop Wiki Documentation")
                .url("https://springshop.wiki.github.org/docs");

        return new OpenAPI()
                .info(info)
                .externalDocs(externalDocumentation);
    }
}

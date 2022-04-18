package org.genesiscode.mockwebsis.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:api-info.properties")
public class OpenApi {

    @Value("${app.info.contact.name}")
    private String contactName;

    @Value("${app.info.contact.email}")
    private String contactEmail;

    @Value("${app.info.license.name}")
    private String nameLicense;

    @Value("${app.info.license.url}")
    private String urlLicense;

    @Value("${app.info.title}")
    private String title;

    @Value("${app.info.description}")
    private String description;

    @Value("${app.info.version}")
    private String version;

    @Value("${app.info.external.documentation.description}")
    private String externalDescription;

    @Value("${app.info.external.documentation.url}")
    private String externalUrl;

    @Bean
    public OpenAPI springShopOpenAPI() {
        Contact contact = new Contact()
                .name(contactName)
                .email(contactEmail);

        License license = new License()
                .name(nameLicense)
                .url(urlLicense);

        Info info = new Info()
                .contact(contact)
                .title(title)
                .description(description)
                .version(version)
                .license(license);

        ExternalDocumentation externalDocumentation = new ExternalDocumentation()
                .description(externalDescription)
                .url(externalUrl);

        return new OpenAPI()
                .info(info)
                .externalDocs(externalDocumentation);
    }
}

package com.cloudinn.backend.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        var tags = new ArrayList<Tag>();
        tags.add(new Tag().name("Users").description("Gerencia os usuários"));
        tags.add(new Tag().name("Rooms").description("Gerencia os quartos"));
        tags.add(new Tag().name("Reservations").description("Gerencia as reservas"));
        tags.add(new Tag().name("Locations").description("Gerencia as localidades"));
        return new OpenAPI()
                .info(new Info()
                        .title("Cloud Inn Back-end API")
                        .version("v1")
                        .description("API da do back-end da aplicação Cloud Inn"))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositório")
                        .url("https://github.com/samuelclinton/hackaton-postech"))
                .tags(tags);
    }

}

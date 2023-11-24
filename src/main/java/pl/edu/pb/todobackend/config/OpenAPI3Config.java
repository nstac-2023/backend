package pl.edu.pb.todobackend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPI3Config {

    @Bean
    public OpenAPI openAPICustomConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("to-do app - documentation of backend api endpoints")
                        .version("1.0.0")
                        .description(""));
    }

}

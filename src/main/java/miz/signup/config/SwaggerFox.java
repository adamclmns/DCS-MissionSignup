package miz.signup.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerFox {
    @Bean
    public GroupedOpenApi configApi(){
        return GroupedOpenApi.builder().pathsToMatch("/**").group("Mission Signup API").build();
    }
}

package miz.signup.config;


import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {
    @Bean
    public GroupedOpenApi configApi(){
        return GroupedOpenApi.builder().pathsToMatch("/api/**").group("Mission Signup API").build();
    }
}

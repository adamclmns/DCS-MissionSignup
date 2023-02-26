package miz.signup;

import miz.signup.config.SpringDocConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SpringDocConfiguration.class})
public class MissionSignupApplication {

    public static void main(String[] args) {
        SpringApplication.run(MissionSignupApplication.class, args);
    }


}

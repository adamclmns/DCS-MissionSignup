package miz.signup;

import com.fasterxml.jackson.databind.ObjectMapper;
import miz.signup.dto.ATO;
import miz.signup.mapper.DtoMapper;
import miz.signup.mapper.EntityMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;



@SpringBootTest(classes = MissionSignupApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ATOParsingTest {

    @Autowired
    private ObjectMapper om;

    @Test
    public void testParsing_HappyPath() throws IOException {
        String initialJson = new String(getClass().getClassLoader().getResourceAsStream("test_ATO_1.json").readAllBytes());
        ATO atoObject = om.readValue(initialJson,ATO.class);
        String outputString = om.writeValueAsString(atoObject);

        Assertions.assertEquals(initialJson.replaceAll("\\s+",""),outputString.replaceAll("\\s+",""),"Both String representations should be equal");

    }
}

package miz.signup;


import com.fasterxml.jackson.databind.ObjectMapper;
import miz.signup.controller.AtoController;
import miz.signup.dto.ATO;
import miz.signup.entities.AtoTable;
import miz.signup.mapper.DtoMapper;
import miz.signup.mapper.EntityMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBeans;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;



@SpringBootTest(classes = MissionSignupApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ATOTableMappingTest {

    @Autowired
    private ObjectMapper om;

    @Test
    public void convertAtoToTableEntity() throws IOException {
        String initialJson = new String(getClass().getClassLoader().getResourceAsStream("test_ATO_1.json").readAllBytes());
        ATO atoObject = om.readValue(initialJson, ATO.class);
        // We have another test that ensures om.readValue() is accurate.
        AtoTable entity = EntityMapper.map(atoObject);
        // Entity is mapped properly.
        ATO fromEntity = DtoMapper.map(entity);
        // Something goes wrong when mapping the entity back to a Dto.
        Assertions.assertEquals(atoObject, fromEntity, "Objects should be equivalent.");
    }
}

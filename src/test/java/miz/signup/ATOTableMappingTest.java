package miz.signup;


import com.fasterxml.jackson.databind.ObjectMapper;
import miz.signup.dto.ATO;
import miz.signup.entities.AtoTable;
import miz.signup.mapper.DtoMapper;
import miz.signup.mapper.EntityMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@Disabled("This test is not yet passing, more fields left to map before this will work.")
@SpringBootTest
public class ATOTableMappingTest {

    @Autowired
    ObjectMapper om;
    @Test
    public void convertAtoToTableEntity() throws IOException {
        String initialJson = new String(getClass().getClassLoader().getResourceAsStream("test_ATO_1.json").readAllBytes());
        ATO atoObject = om.readValue(initialJson,ATO.class);

        AtoTable entity = EntityMapper.map(atoObject);
        ATO fromEntity = DtoMapper.map(entity);
        Assertions.assertEquals(atoObject,fromEntity,"Objects should be equivalent.");
    }
}

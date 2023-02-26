package miz.signup.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import miz.signup.dto.ATO;
import miz.signup.entities.AtoEntity;
import miz.signup.mapper.EntityMapper;
import miz.signup.repos.AtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Slf4j
@Component
@ConditionalOnProperty(name = "create.default.data")
public class SampleDataBean {

    @Autowired
    AtoRepository atoRepository;
    @Autowired
    ObjectMapper objectMapper;

    @PostConstruct
    private void buildATOFromNothing() {
        log.info("Creating Sample record for testing");
        try {
            String initialJson = new String(getClass().getClassLoader().getResourceAsStream("test_ATO_1.json").readAllBytes());
            ATO atoObject = objectMapper.readValue(initialJson, ATO.class);
            AtoEntity atoEntity = EntityMapper.map(atoObject);

            atoRepository.save(atoEntity);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

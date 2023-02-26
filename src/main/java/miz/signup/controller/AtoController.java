package miz.signup.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import miz.signup.dto.ATO;
import miz.signup.dto.EMissionType;
import miz.signup.entities.*;
import miz.signup.mapper.DtoMapper;
import miz.signup.mapper.EntityMapper;
import miz.signup.repos.AtoRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collection;

@RequestMapping("api/ato")
@RestController
public class AtoController {

    final
    AtoRepository atoRepository;
    final ObjectMapper objectMapper;

    private void buildATOFromNothing() {

        try {
            String initialJson = new String(getClass().getClassLoader().getResourceAsStream("test_ATO_1.json").readAllBytes());
            ATO atoObject = objectMapper.readValue(initialJson, ATO.class);
            atoRepository.save(EntityMapper.map(atoObject));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public AtoController(AtoRepository atoRepository,ObjectMapper objectMapper) {
        this.atoRepository = atoRepository;
        this.atoRepository.deleteAll();
        this.objectMapper = objectMapper;
        buildATOFromNothing();;

    }

    @PostMapping
    public ATO post(@RequestBody ATO ato) {
        return DtoMapper.map(atoRepository.save(EntityMapper.map(ato)));
    }

    @GetMapping
    public Collection<ATO> getAll() {
        Collection<AtoTable> atoEntities = atoRepository.findAll();
        return DtoMapper.map(atoEntities);
    }

    @GetMapping("{id}")
    public ATO getById(@PathVariable("id") Long id) {
        return DtoMapper.map(atoRepository.findById(id)).orElse(null);
    }


}

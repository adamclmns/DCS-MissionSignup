package miz.signup.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import miz.signup.dto.ATO;
import miz.signup.dto.BriefingDocument;
import miz.signup.dto.EMissionType;
import miz.signup.entities.*;
import miz.signup.mapper.DtoMapper;
import miz.signup.mapper.EntityMapper;
import miz.signup.repos.AtoRepository;
import miz.signup.repos.BriefingDocumentRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("api/ato")
@RestController
@Slf4j
public class AtoController {

    final AtoRepository atoRepository;
    final ObjectMapper objectMapper;




    public AtoController(AtoRepository atoRepository,ObjectMapper om) {
        this.atoRepository = atoRepository;
        this.objectMapper = om;


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

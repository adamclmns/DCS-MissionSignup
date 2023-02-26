package miz.signup.controller;

import miz.signup.dto.FlightLine;
import miz.signup.entities.AtoEntity;
import miz.signup.mapper.DtoMapper;
import miz.signup.repos.AtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ato/{atoId}/lines")
public class FlightLinesController {

    @Autowired AtoRepository atoRepository;

    @GetMapping
    public Collection<FlightLine> getFlightLinesForAto(@PathVariable Long atoId){
        Optional<AtoEntity> atoEntity = atoRepository.findById(atoId);
        if(atoEntity.isPresent()){
            return atoEntity.stream().flatMap(v -> v.getFlightLines().stream()).map(DtoMapper::map).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}

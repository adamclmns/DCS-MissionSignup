package miz.signup.controller;

import miz.signup.dto.ATO;
import miz.signup.dto.EMissionType;
import miz.signup.entities.*;
import miz.signup.mapper.DtoMapper;
import miz.signup.mapper.EntityMapper;
import miz.signup.repos.AtoRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collection;

@RequestMapping("ato")
@RestController
public class AtoController {

    final
    AtoRepository atoRepository;

    private static AtoTable buildATOFromNothing(){

        return AtoTable.builder()
                .name("test")
                .identifier("test001")
                .time_from(
                        DualStartTimesTable.builder()
                                .ingame(LocalDateTime.now().plusDays(6L))
                                .outgame(LocalDateTime.now().plusDays(5L))
                                .build()
                )
                .time_to(
                        DualEndTimesTable.builder()
                                .ingame(LocalDateTime.now().plusDays(6L).plusHours(3L))
                                .outgame(LocalDateTime.now().plusDays(5L).plusHours(3L))
                                .build()
                )
                .documents(Arrays.asList(
                        BriefingDocumentTable.builder().name("BriefingPDF").directory("C:/Users/Mine/PDFs/Briefing.pdf").build()
                ))
                .flightLines(Arrays.asList(
                        FlightLineTable.builder()
                                .arinfo(AirRefuelInfoTable.builder()
                                        .ac_type("KC-135 MPRS")
                                        .frequency(FrequencyTable.builder().freq(305.00).name("ARCO").build())
                                        .tacan("11Y")
                                        .build())
                                .msndat(
                                        MissionDataTable.builder().mission_num(1).num_ac(4).prim_msn(EMissionType.DEAD).build()
                                )
                                        .build())
                )
                .timezone("Central")
                .build();
    }
    public AtoController(AtoRepository atoRepository) {
        this.atoRepository = atoRepository;
        this.atoRepository.deleteAll();
        atoRepository.save(buildATOFromNothing());

    }

    @PostMapping
    public ATO post(@RequestBody ATO ato){
        return DtoMapper.map(atoRepository.save(EntityMapper.map(ato)));
    }

    @GetMapping
    public Collection<ATO> getAll(){
        Collection<AtoTable> atoEntities = atoRepository.findAll();
        return DtoMapper.map(atoEntities);
    }

    @GetMapping("{id}")
    public ATO getById(@PathVariable("id") Long id){
        return DtoMapper.map(atoRepository.findById(id)).orElse(null);
    }




}

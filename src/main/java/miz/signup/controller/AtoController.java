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

@RequestMapping("api/ato")
@RestController
public class AtoController {

    final
    AtoRepository atoRepository;

    private static AtoTable buildATOFromNothing() {

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
                                ).amsnloc(
                                        AirMissionLocationTable.builder().location_name("Location Name").end_time(LocalDateTime.now().plusDays(12)).start_time(LocalDateTime.now().plusDays(11)).msn_altitude(10000).build()
                                ).pkgcmd(
                                        PackageCommandTable.builder().pkg_cmdr_cs(
                                                CallsignTable.builder().prefix("Colt").suffix01(11).suffix02(12).suffix03(13).suffix04(14).build()
                                        ).build()
                                ).pkgdat(Arrays.asList(
                                                PackageDataTable.builder().ac_cs(CallsignTable.builder().prefix("Chevy").suffix01(01).build()).ac_type("F/A-18")
                                                        .mission_num(1).tasked_unit("Tasked Unit").prim_msn(EMissionType.DEAD)
                                                        .build()
                                        )
                                ).gtgtloc(Arrays.asList(
                                                GroundTargetLocationTable.builder().target_id(2).description("Kill this thing, please").net(LocalDateTime.now()).nlt(LocalDateTime.now()).tot(LocalDateTime.now())
                                                        .priority("Moderate")
                                                        .build()
                                        )
                                ).signups(
                                        Arrays.asList(
                                                SignUpTable.builder().type("F-16 Command Flight").build(),
                                                SignUpTable.builder().type("F/A-18 DEAD Flight").build()
                                        )
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

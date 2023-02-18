package miz.signup.entities;

import jakarta.persistence.*;
import lombok.*;
import miz.signup.dto.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="flight_lines")
public class FlightLineTable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @OneToOne(cascade = {CascadeType.ALL})
    private MissionDataTable msndat;
    @OneToOne(cascade = {CascadeType.ALL})
    private AirMissionLocationTable amsnloc;
//    @OneToMany
//    private List<GroundTargetLocation> gtgtloc;
//    @OneToMany
//    private List<PackageData> pkgdat;
//    @OneToOne
//    private PackageCommand pkgcmd;
    @ManyToOne(cascade = {CascadeType.ALL})
    private AirRefuelInfoTable arinfo;
//    @OneToOne
//    private List<Signup> signups;
}


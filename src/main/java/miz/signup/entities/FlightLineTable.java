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
    private Long id;
    @OneToOne(cascade = {CascadeType.ALL})
    private MissionDataTable msndat;
    @OneToOne(cascade = {CascadeType.ALL})
    private AirMissionLocationTable amsnloc;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<GroundTargetLocationTable> gtgtloc;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<PackageDataTable> pkgdat;
    @ManyToOne(cascade = {CascadeType.ALL})
    private PackageCommandTable pkgcmd;
    @ManyToOne(cascade = {CascadeType.ALL})
    private AirRefuelInfoTable arinfo;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<SignUpTable> signups;
}


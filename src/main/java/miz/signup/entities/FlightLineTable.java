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
    @OneToMany(cascade = {CascadeType.ALL})
    private List<GroundTargetLocationTable> gtgtloc = new java.util.ArrayList<>();
    @OneToMany(cascade = {CascadeType.ALL})
    private List<PackageDataTable> pkgdat = new java.util.ArrayList<>();
    @ManyToOne(cascade = {CascadeType.ALL})
    private PackageCommandTable pkgcmd;
    @ManyToOne(cascade = {CascadeType.ALL})
    private AirRefuelInfoTable arinfo;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<SignUpTable> signups;
}


package miz.signup.entities;

import javax.persistence.*;
import lombok.*;

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
    private AirMissionLocationEntity amsnloc;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<GroundTargetLocationTable> gtgtloc;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<PackageDataTable> pkgdat;
    @OneToOne(cascade = {CascadeType.ALL})
    private PackageCommandTable pkgcmd;
    @OneToOne(cascade = {CascadeType.ALL})
    private AirRefuelInfoTable arinfo;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
    private List<SignUpTable> signups = new java.util.ArrayList<>();

    @JoinColumn(name = "atoId")
    @ManyToOne(cascade = {CascadeType.ALL})
    private AtoEntity ato;

}


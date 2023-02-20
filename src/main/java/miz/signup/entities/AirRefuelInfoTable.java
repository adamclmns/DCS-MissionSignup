package miz.signup.entities;

import jakarta.persistence.*;
import lombok.*;
import miz.signup.dto.Callsign;
import miz.signup.dto.Frequency;

@Entity
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="air_refule_info")
public class AirRefuelInfoTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    Long id;
    @ManyToOne(cascade = {CascadeType.ALL})
    private CallsignTable tnkr_cs;
    @Column(name="tnkr_cp")
    private String tnkr_cp;
    @Column(name="tnkr_alt")
    private Integer tnkr_alt;
    @Column(name="tnkr_speed")
    private Integer tnkr_speed;
    @Column(name="offload")
    private Double offload;
    @ManyToOne(cascade = {CascadeType.ALL})
    private FrequencyTable frequency;
    @Column(name="ac_type")
    private String ac_type;
    @Column(name="refule_system")
    private String refule_system;
    @Column(name="tacan")
    private String tacan;
}

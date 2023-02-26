package miz.signup.entities;

import lombok.*;
import miz.signup.dto.EMissionType;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="mission_data")
public class MissionDataTable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(name="taskedUnit")
    private String taskedUnit;
    @Column(name="mission_num")
    private Integer mission_num;
    @Column(name="num_aircraft")
    private Integer num_ac;
    private String ac_type;
    @OneToOne(cascade = {CascadeType.ALL})
    private CallsignTable ac_cs;
    private EMissionType prim_msn;
    private  EMissionType sec_msn;
    @ManyToOne(cascade = {CascadeType.ALL})
    private BaseLocationTable dep_location;
    @ManyToOne(cascade = {CascadeType.ALL})
    private BaseLocationTable rec_location;
    private String mode_3; // String.join() integers together.

}

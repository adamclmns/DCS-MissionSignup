package miz.signup.entities;

import jakarta.persistence.*;
import lombok.*;
import miz.signup.dto.BaseLocation;
import miz.signup.dto.Callsign;
import miz.signup.dto.EMissionType;

import java.util.List;

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
    @OneToOne(cascade = {CascadeType.ALL})
    private CallsignTable ac_cs;
    private EMissionType prim_msn;
    private  EMissionType sec_msn;
//    private BaseLocation dep_location;
//    private BaseLocation rec_location;
//    private List<Integer> mode_3;

}

package miz.signup.entities;

import jakarta.persistence.*;
import lombok.*;
import miz.signup.dto.Callsign;
import miz.signup.dto.EMissionType;

@Entity
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "package_data_table")
public class PackageDataTable {


    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String pkg_id;
    private String tasked_unit;
    private Integer mission_num;
    private EMissionType prim_msn;
    private String ac_type;
    @OneToOne(cascade = {CascadeType.ALL})
    private CallsignTable ac_cs;

}
package miz.signup.entities;

import javax.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "package_command_table")
public class PackageCommandTable {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String pkg_id;
    private String pkg_cmdr_unit_id;
    private Integer pkg_cmdr_mission_num;
    @OneToOne(cascade = {CascadeType.ALL})
    private CallsignTable pkg_cmdr_cs;
}
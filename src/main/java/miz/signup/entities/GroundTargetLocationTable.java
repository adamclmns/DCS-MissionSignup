package miz.signup.entities;

import jakarta.persistence.*;
import lombok.*;
import miz.signup.dto.Coordinate;

import java.time.LocalDateTime;
@Entity
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "ground_target_location_table")
public class GroundTargetLocationTable {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    Integer target_id;
    LocalDateTime net;
    LocalDateTime nlt;
    LocalDateTime tot;
    String priority;
    String description;
    @OneToOne(cascade = {CascadeType.ALL})
    CoordinateTable dmpi;

}
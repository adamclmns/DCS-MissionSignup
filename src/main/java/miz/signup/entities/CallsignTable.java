package miz.signup.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="callsigns")
public class CallsignTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id") Long id;

    @Column(name="prefix")
    String prefix;
    @Column(name="suffix_01")
    Integer suffix01;
    @Column(name="suffix_02")
    Integer suffix02;
    @Column(name="suffix_03")
    Integer suffix03;
    @Column(name="suffix_04")
    Integer suffix04;
}

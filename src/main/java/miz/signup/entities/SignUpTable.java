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
@Table(name="signupTable")
public class SignUpTable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    private String type;
    @Column(name="user01")
    private String user01;
    @Column(name="user02")
    private String user02;
    @Column(name="user03")
    private String user03;
    @Column(name="user04")
    private String user04;
}

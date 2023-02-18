package miz.signup.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "air_refule_info")
public class FrequencyTable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(name = "name",unique = true)
    private String name;
    @Column(name = "freq")
    private Double freq;
}

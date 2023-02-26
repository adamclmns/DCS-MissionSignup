package miz.signup.entities;


import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "freq")
    private Double freq;
}

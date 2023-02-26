package miz.signup.entities;

import javax.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="air_targeting_order")
public class AtoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Long id;
    @Column(name="identifier", unique = true)
    private String identifier;
    @Column(name="name")
    private String name;
    @Column(name="timezone")
    private String timezone;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<BriefingDocumentTable> documents = new java.util.ArrayList<>();
    private LocalDateTime time_from_ingame;
    private LocalDateTime time_from_outgame;
    private LocalDateTime time_to_ingame;
    private LocalDateTime time_to_outgame;
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<FlightLineTable> flightLines;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AtoEntity atoEntity = (AtoEntity) o;
        return id != null && Objects.equals(id, atoEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

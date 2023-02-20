package miz.signup.entities;

import jakarta.persistence.*;
import lombok.*;
import miz.signup.dto.BriefingDocument;
import org.hibernate.Hibernate;

import java.time.ZoneId;
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
public class AtoTable {
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
    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<BriefingDocumentTable> documents;
    @OneToOne(cascade = {CascadeType.ALL})
    private DualStartTimesTable time_from;
    @OneToOne(cascade = {CascadeType.ALL})
    private DualEndTimesTable time_to;
    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<FlightLineTable> flightLines;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AtoTable atoTable = (AtoTable) o;
        return id != null && Objects.equals(id, atoTable.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

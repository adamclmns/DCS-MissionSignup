package miz.signup.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class AirMissionLocationTable {
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="start_time")
    private ZonedDateTime start_time;
    @Column(name="end_time")
    private ZonedDateTime end_time;
    @Column(name="location_name")
    private String location_name;
    @Column(name="msn_altitude")
    private Integer msn_altitude;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AirMissionLocationTable that = (AirMissionLocationTable) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

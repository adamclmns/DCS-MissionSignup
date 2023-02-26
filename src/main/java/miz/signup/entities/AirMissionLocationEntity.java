package miz.signup.entities;

import javax.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class AirMissionLocationEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="start_time")
    private LocalDateTime start_time;
    @Column(name="end_time")
    private LocalDateTime end_time;
    @Column(name="location_name")
    private String location_name;
    @Column(name="msn_altitude")
    private Integer msn_altitude;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AirMissionLocationEntity that = (AirMissionLocationEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @OneToOne(mappedBy = "amsnloc", optional = false)
    private FlightLineTable flightLineTable;

    public FlightLineTable getFlightLineTable() {
        return flightLineTable;
    }

    public void setFlightLineTable(FlightLineTable flightLineTable) {
        this.flightLineTable = flightLineTable;
    }
}

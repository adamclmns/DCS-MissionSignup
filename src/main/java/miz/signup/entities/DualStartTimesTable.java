package miz.signup.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="dual_start_times")
public class DualStartTimesTable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    LocalDateTime ingame;
    LocalDateTime outgame;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DualStartTimesTable dualStartTimesTable = (DualStartTimesTable) o;
        return id != null && Objects.equals(id, dualStartTimesTable.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

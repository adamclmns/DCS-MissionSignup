package miz.signup.repos;

import miz.signup.entities.AtoTable;
import miz.signup.entities.FlightLineTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface FlightLineRepository extends JpaRepository<FlightLineTable, Long> {
}

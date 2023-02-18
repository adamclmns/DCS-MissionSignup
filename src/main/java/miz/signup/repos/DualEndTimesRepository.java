package miz.signup.repos;

import miz.signup.entities.AtoTable;
import miz.signup.entities.DualEndTimesTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface DualEndTimesRepository extends JpaRepository<DualEndTimesTable, Long> {
}

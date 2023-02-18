package miz.signup.repos;

import miz.signup.entities.AtoTable;
import miz.signup.entities.DualStartTimesTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface DualStartTimesRepository extends JpaRepository<DualStartTimesTable, Long> {
}

package miz.signup.repos;

import miz.signup.entities.FrequencyTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface FrequencyRepository extends JpaRepository<FrequencyTable, Long> {
}

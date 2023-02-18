package miz.signup.repos;

import miz.signup.entities.AtoTable;
import miz.signup.entities.MissionDataTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface MissionDataRepository extends JpaRepository<MissionDataTable, Long> {
}

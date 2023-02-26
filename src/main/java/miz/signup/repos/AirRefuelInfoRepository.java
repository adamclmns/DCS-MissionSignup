package miz.signup.repos;

import miz.signup.entities.AirRefuelInfoTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AirRefuelInfoRepository extends JpaRepository<AirRefuelInfoTable, Long> {
}

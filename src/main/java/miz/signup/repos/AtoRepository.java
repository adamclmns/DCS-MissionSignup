package miz.signup.repos;

import miz.signup.entities.AtoTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AtoRepository extends JpaRepository<AtoTable, Long> {

}

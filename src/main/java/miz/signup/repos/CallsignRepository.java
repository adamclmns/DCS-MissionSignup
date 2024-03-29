package miz.signup.repos;

import miz.signup.entities.CallsignTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CallsignRepository extends JpaRepository<CallsignTable, Long> {
}

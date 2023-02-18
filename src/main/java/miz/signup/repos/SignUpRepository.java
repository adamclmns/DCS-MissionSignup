package miz.signup.repos;

import miz.signup.entities.AtoTable;
import miz.signup.entities.SignUpTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface SignUpRepository extends JpaRepository<SignUpTable, Long> {
}

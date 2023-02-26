package miz.signup.repos;

import miz.signup.entities.SignUpTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface SignUpRepository extends JpaRepository<SignUpTable, Long> {
    Optional<SignUpTable> findSignUpTableById(Long id);
    SignUpTable save(SignUpTable s);
}

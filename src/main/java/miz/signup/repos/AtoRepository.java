package miz.signup.repos;

import miz.signup.entities.AtoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AtoRepository extends JpaRepository<AtoEntity, Long> {
    Optional<AtoEntity> findAtoEntityByIdentifier(String identifier);
}

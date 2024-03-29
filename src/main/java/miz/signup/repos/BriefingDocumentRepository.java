package miz.signup.repos;

import miz.signup.entities.BriefingDocumentTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface BriefingDocumentRepository extends JpaRepository<BriefingDocumentTable, Long> {
    BriefingDocumentTable save(BriefingDocumentTable entity);
}

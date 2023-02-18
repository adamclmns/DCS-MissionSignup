package miz.signup.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;

@Entity
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="briefing_documents")
public class BriefingDocumentTable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    Long id;
    @Column(name = "directory")
    private String directory;
    @Column(name="name")
    private String name;
}

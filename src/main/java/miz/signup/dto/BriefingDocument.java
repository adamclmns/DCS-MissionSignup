package miz.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

/**
 * { "directory": "uploads/pdf/fdgh1w.pf", "name": "Threat Brief" }
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BriefingDocument {
    private Long _id;
    private String directory;
    private String name;
}

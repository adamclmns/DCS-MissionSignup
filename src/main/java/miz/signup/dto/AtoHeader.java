package miz.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.time.ZoneId;
import java.util.List;
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AtoHeader {
    private String identifier;
    private String name;
    private String timezone;
    private DualZonedDateTime time_from;
    private DualZonedDateTime time_to;
    private List<BriefingDocument> documents;
}

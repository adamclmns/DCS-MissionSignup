package miz.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AtoHeader {

    private String id;
    private String name;
    private String timezone;
    private DualZonedDateTime time_from;
    private DualZonedDateTime time_to;
    private List<BriefingDocument> documents;
}

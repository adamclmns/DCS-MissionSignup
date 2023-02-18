package miz.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.ZoneId;
import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ATO {
    private Long _id;
    @JsonProperty("id")
    private String identifier;
    private String name;
    private ZoneId timezone;
    private DualZonedDateTime time_from;
    private DualZonedDateTime time_to;
    private List<BriefingDocument> documents;

    private  List<FlightLine> lines;
}

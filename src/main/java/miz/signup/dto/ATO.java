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
    @JsonProperty("id")
    private Long _id;

    private AtoHeader header;

    private  List<FlightLine> lines;
}

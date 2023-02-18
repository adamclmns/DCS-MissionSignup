package miz.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * { "lat": 51.754534, "long": 36.296602, "elev": 509 }
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinate {
    private Long _id;
    private Double lat;
    @JsonProperty("long")
    private Double lon;
    private Integer elevation;
}

package miz.signup.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

/**
 * { "icao": "CVN-72", "name": "USS Abraham Lincoln" }
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseLocation {
    private Long _id;
    private String name;
    private String icao;
}

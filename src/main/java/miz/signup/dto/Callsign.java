package miz.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * { "prefix": "NIKEL", "suffix": [21,22,23,24] }
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Callsign {
    private Long _id;
    String prefix;
    private List<Integer> suffix;

}

package miz.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * { "type": "Pilot", "users": ["Terry", null, "B-SACC", null] }
 */
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Signup {
    private Long _id;
    private String type;
    // TODO: Maybe a Map here? JSON List order is not guaranteed.
    private List<String> users;
}

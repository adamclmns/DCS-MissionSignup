package miz.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * {
 * 					"target_id": 001,
 * 					"net": null, //No Earlier Than
 * 					"nlt": null, // Not Later Than
 * 					"tot": "2023-05-03 18:00:00", // Time on Target
 * 					"priority": "P", // "P" = Primary, "A" = Alternate
 * 					"description": "Air Traffic Control Tower",
 * 					"dmpi": { "lat": 51.754534, "long": 36.296602, "elev": 509 }
 *                                },
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroundTargetLocation {
    private Long _id;
    Integer target_id;
    LocalDateTime net;
    LocalDateTime nlt;
    LocalDateTime tot;
    String priority;
    String description;
    Coordinate dmpi;

}

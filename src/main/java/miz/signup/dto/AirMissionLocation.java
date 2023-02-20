package miz.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 *              {
 * 				"start_time": "2022-12-24 20:55:20",
 * 				"end_time": "2022-12-24 22:00:00",
 * 				"location_name": "ROZ DAKOTA",
 * 				"msn_altitude": "280"
 *             }
 */
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirMissionLocation {
    private Long _id;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private String location_name;
    private Integer msn_altitude;
}

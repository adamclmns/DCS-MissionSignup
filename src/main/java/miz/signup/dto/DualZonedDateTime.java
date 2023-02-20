package miz.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * { "ingame": "2022-12-07 19:04:27", "outgame": "2022-12-07 19:04:27" }
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DualZonedDateTime {
    private Long _id;
    LocalDateTime ingame;
    LocalDateTime outgame;

}

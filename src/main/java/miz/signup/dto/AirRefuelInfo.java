package miz.signup.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

/**
 *
 * {
 * 				"tnkr_cs": { "prefix": "SHELL", "suffix": [11] },
 * 				"tnkr_cp": "ARIP ALAMO",
 * 				"tnkr_alt": 200,
 * 				"tnkr_speed": 276,
 * 				"offload": 7.5, // in thousands of pounds
 * 				"frequency": { "name": "AR701", "freq": 316.700 },
 * 				"ac_type": "KC-135 MPRS",
 * 				"refuel_system": "CDT", // BOM = Boom, CDT = ?
 * 				"tacan": "107X"
 *                        }
 */
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirRefuelInfo {
    private Long _id;
    private Callsign tnkr_cs;
    private String tnkr_cp;
    private Integer tnkr_alt;
    private Integer tnkr_speed;
    private Double offload;
    private Frequency frequency;
    private String ac_type;
    private String refuel_system;
    private String tacan;
}

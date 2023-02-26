package miz.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

/**
 * {
 * 				"pkg_id": "A",
 * 				"pkg_cmdr_unit_id": "VMFA-122",
 * 				"pkg_cmdr_mission_num": 001,
 * 				"pkg_cmdr_cs": { "prefix": "NIKEL", "suffix": [11] }
 *                        }
 */
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackageCommand {
    private Long _id;
    private String pkg_id;
    private String pkg_cmdr_unit_id;
    private Integer pkg_cmdr_mission_num;
    private Callsign pkg_cmdr_cs;

}

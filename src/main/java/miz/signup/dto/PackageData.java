package miz.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

/**
 *
 *
 *              {
 * 					"pkg_id": "A",
 * 					"tasked_unit": "VMFA-122",
 * 					"mission_num": 002,
 * 					"prim_msn": "DCA",
 * 					"num_ac": 2,
 * 					"ac_type": "F/A-18C lot. 20",
 * 					"ac_cs":  { "prefix": "NIKEL", "suffix": [21,22,23,24] },
 *               },
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackageData {
    private Long _id;
    private String pkg_id;
    private String tasked_unit;
    private Integer mission_num;
    private EMissionType prim_msn;
    private Integer num_ac;
    private String ac_type;
    private Callsign ac_cs;

}

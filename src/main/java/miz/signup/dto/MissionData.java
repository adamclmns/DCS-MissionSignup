package miz.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * {
 * "tasked_unit": "VMFA-122", // Unit name shorthanded
 * "mission_num": 001, //mission number, letters is the ATO Day. the 3 numbers is the flight identifier starting at 001 and counting up
 * "num_ac": 2,
 * "ac_type": "F/A-18C lot. 20",
 * "ac_cs": { "prefix": "NIKEL", "suffix": [11,12] },
 * "prim_msn": "STK",
 * "sec_msn": "SCAR",
 * "dep_location": { "icao": "UG27", "name": "Vaziani Airport" },
 * "rec_location": { "icao": "CVN-72", "name": "USS Abraham Lincoln" },
 * "mode_3": [2211,2212]
 * }
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MissionData {
    private Long _id;
    private String taskedUnit;
    private Integer mission_num;
    private Integer num_ac;
    private Callsign ac_cs;
    private EMissionType prim_msn;
    private EMissionType sec_msn;
    private BaseLocation dep_location;
    private BaseLocation rec_location;
    private List<Integer> mode_3;
}

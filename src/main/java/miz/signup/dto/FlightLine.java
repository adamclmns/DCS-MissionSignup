package miz.signup.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightLine {
    private Long _id;
    private MissionData msndat;
    private AirMissionLocation amsnloc;
    private List<GroundTargetLocation> gtgtloc;
    private List<PackageData> pkgdat;
    private PackageCommand pkgcmd;
    private AirRefuelInfo arinfo;
    private List<Signup> signups;
}

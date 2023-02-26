package miz.signup.mapper;

import miz.signup.dto.*;
import miz.signup.entities.*;

import java.util.List;
import java.util.stream.Collectors;

public class EntityMapper {
    public static AtoTable map(ATO ato) {
        AtoTable.AtoTableBuilder builder = AtoTable.builder();
        if (ato.get_id() != null) {
            builder.id(ato.get_id());
        }
        builder.name(ato.getHeader().getName())
                .identifier(ato.getHeader().getIdentifier());
        builder.time_to(
                mapToEnd(ato.getHeader().getTime_from())
        ).time_from(
                maptoStart(ato.getHeader().getTime_to())
        );
        builder.documents(
                        map(ato.getHeader().getDocuments())
                ).timezone(ato.getHeader().getTimezone())
                .flightLines(
                        mapFlightLines(ato.getLines())
                );
        return builder.build();
    }


    public static FlightLineTable map(FlightLine line) {
        return FlightLineTable.builder()
                .id(line.get_id())
                .msndat(map(line.getMsndat()))
                .amsnloc(map(line.getAmsnloc()))
                .arinfo(map(line.getArinfo()))
                .gtgtloc(mapGroundTargetLocations(line.getGtgtloc()))
                .build();
    }

    private static List<GroundTargetLocationTable> mapGroundTargetLocations(List<GroundTargetLocation> gtgtloc) {
        if(gtgtloc != null && !gtgtloc.isEmpty()) {
            return gtgtloc.stream().map(EntityMapper::map).collect(Collectors.toList());
        }
            return null;

    }

    private static GroundTargetLocationTable map(GroundTargetLocation groundTargetLocation) {
        if(groundTargetLocation != null) {
            GroundTargetLocationTable.GroundTargetLocationTableBuilder builder = GroundTargetLocationTable.builder();
            if (groundTargetLocation.get_id() != null) {
                builder.id(groundTargetLocation.get_id());
            }
            return builder.tot(groundTargetLocation.getTot())
                    .nlt(groundTargetLocation.getNlt())
                    .target_id(groundTargetLocation.getTarget_id())
                    .net(groundTargetLocation.getNet())
                    .priority(groundTargetLocation.getPriority())
                    .description(groundTargetLocation.getDescription())
                    .build();
        }else{
            return null;
        }
    }

    public static List<FlightLineTable> mapFlightLines(List<FlightLine> lines) {
        return lines.stream().map(EntityMapper::map).collect(Collectors.toList());
    }

    public static AirRefuelInfoTable map(AirRefuelInfo refuelInfo) {
        return AirRefuelInfoTable.builder()
                .id(refuelInfo.get_id())
                .tacan(refuelInfo.getTacan())
                .frequency(map(refuelInfo.getFrequency()))
                .ac_type(refuelInfo.getAc_type())
                .offload(refuelInfo.getOffload())
                .refule_system(refuelInfo.getRefuel_system())
                .tnkr_alt(refuelInfo.getTnkr_alt())
                .tnkr_cp(refuelInfo.getTnkr_cp())
                .tnkr_cs(map(refuelInfo.getTnkr_cs()))
                .tnkr_speed(refuelInfo.getTnkr_speed())
                .build();
    }

    public static CallsignTable map(Callsign callsign) {
        CallsignTable.CallsignTableBuilder builder = CallsignTable.builder()
                .id(callsign.get_id())
                .prefix(callsign.getPrefix());
        if (callsign.getSuffix() != null) {
            if (callsign.getSuffix().size() >= 1) {
                builder.suffix01(callsign.getSuffix().get(0));
            }
            if (callsign.getSuffix().size() >= 2) {
                builder.suffix01(callsign.getSuffix().get(1));
            }
            if (callsign.getSuffix().size() >= 3) {
                builder.suffix01(callsign.getSuffix().get(2));
            }
            if (callsign.getSuffix().size() >= 4) {
                builder.suffix01(callsign.getSuffix().get(3));
            }
        }
        return builder.build();

    }

    public static FrequencyTable map(Frequency freq) {
        return FrequencyTable.builder()
                .id(freq.get_id())
                .name(freq.getName())
                .freq(freq.getFreq())
                .build();
    }

    public static AirMissionLocationTable map(AirMissionLocation location) {
        if(location != null) {
            return AirMissionLocationTable.builder()
                    .location_name(location.getLocation_name())
                    .end_time(location.getEnd_time())
                    .start_time(location.getStart_time())
                    .msn_altitude(location.getMsn_altitude())
                    .build();
        }
        return null;
    }

    public static MissionDataTable map(MissionData missionData) {
        return MissionDataTable.builder()
                .prim_msn(missionData.getPrim_msn())
                .num_ac(missionData.getNum_ac())
                .mission_num(missionData.getMission_num())
                .dep_location(map(missionData.getDep_location()))
                .rec_location(map(missionData.getRec_location()))
                .ac_type(missionData.getAc_type())
                .sec_msn(missionData.getSec_msn())
                .ac_cs(map(missionData.getAc_cs()))
                .taskedUnit(missionData.getTasked_unit())
                .build();
    }
    public static BaseLocationTable map(BaseLocation table){
        BaseLocationTable.BaseLocationTableBuilder builder = BaseLocationTable.builder();
        if(table.get_id() != null)
            builder.id(table.get_id());
        builder.icao(table.getIcao()).name(table.getName());
        return builder.build();
    }

    public static List<BriefingDocumentTable> map(List<BriefingDocument> docs) {
        if (docs != null && !docs.isEmpty()) {
            return docs.stream().map(EntityMapper::map).collect(Collectors.toList());
        }
        return null;
    }

    public static BriefingDocumentTable map(BriefingDocument doc) {
        if (doc != null) {
            BriefingDocumentTable.BriefingDocumentTableBuilder builder = BriefingDocumentTable.builder();
            if (doc.get_id() != null) {
                builder.id(doc.get_id());
            }
            return builder.directory(doc.getDirectory()).name(doc.getName()).build();
        }
        return null;
    }

    public static DualStartTimesTable maptoStart(DualZonedDateTime start) {
        if (start != null) {
            DualStartTimesTable.DualStartTimesTableBuilder builder = DualStartTimesTable.builder();
            if (start.get_id() != null) {
                builder.id(start.get_id());
            }
            return builder.ingame(start.getIngame()).outgame(start.getOutgame()).build();
        }
        return null;
    }

    public static DualEndTimesTable mapToEnd(DualZonedDateTime end) {
        if (end != null) {
            DualEndTimesTable.DualEndTimesTableBuilder builder = DualEndTimesTable.builder();
            if (end.get_id() != null) {
                builder.id(end.get_id());
            }
            return builder.ingame(end.getIngame()).outgame(end.getOutgame()).build();
        }
        return null;
    }


}


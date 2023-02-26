package miz.signup.mapper;

import lombok.extern.slf4j.Slf4j;
import miz.signup.dto.*;
import miz.signup.entities.*;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
public class EntityMapper {
    public static AtoTable map(ATO ato) {
        AtoTable.AtoTableBuilder builder = AtoTable.builder();
        if (ato.get_id() != null) {
            builder.id(ato.get_id());
        }
        builder
                .name(ato.getHeader().getName())
                .identifier(ato.getHeader().getId())
                .time_to_ingame(
                        ato.getHeader().getTime_to().getIngame())
                .time_to_outgame(
                        ato.getHeader().getTime_to().getOutgame()
                )
                .time_from_ingame(
                        ato.getHeader().getTime_from().getIngame()
                )
                .time_from_outgame(
                        ato.getHeader().getTime_from().getOutgame()
                )
                .documents(
                        map(ato.getHeader().getDocuments())
                ).timezone(ato.getHeader().getTimezone())
                .flightLines(
                        mapFlightLines(ato.getLines())
                );
        return builder.build();
    }


    public static FlightLineTable map(FlightLine dto) {
        return FlightLineTable.builder()
                .id(dto.get_id())
                .msndat(map(dto.getMsndat()))
                .amsnloc(map(dto.getAmsnloc()))
                .arinfo(map(dto.getArinfo()))
                .gtgtloc(mapGroundTargetLocations(dto.getGtgtloc()))
                .pkgcmd(map(dto.getPkgcmd()))
                .pkgdat(mapPackageData(dto.getPkgdat()))
                .signups(mapSignups(dto.getSignups()))
                .build();
    }

    private static List<SignUpTable> mapSignups(List<Signup> dtos) {
        if(dtos != null && !dtos.isEmpty()){
            return dtos.stream().map(EntityMapper::map).collect(Collectors.toList());
        }
        return null;
    }

    private static SignUpTable map(Signup dto) {
        if(dto != null ){
            SignUpTable.SignUpTableBuilder builder = SignUpTable.builder();
            if(dto.get_id() != null){
                builder.id(dto.get_id());
            }
            builder.type(dto.getType());

            if(dto.getUsers().size() >= 1){
                builder.user01(dto.getUsers().get(0));
            }
            if(dto.getUsers().size() >= 2){
                builder.user02(dto.getUsers().get(1));
            }
            if(dto.getUsers().size() >= 3){
                builder.user03(dto.getUsers().get(2));
            }
            if(dto.getUsers().size() == 4){
                builder.user04(dto.getUsers().get(3));
            }
            return builder.build();
        }
        return null;
    }

    private static List<PackageDataTable> mapPackageData(List<PackageData> dtos) {
            if(dtos != null && !dtos.isEmpty()){
                return dtos.stream().map(EntityMapper::map).collect(Collectors.toList());
            }
        return null;
    }
    private static PackageDataTable map(PackageData dto){
        if(dto != null){
            PackageDataTable.PackageDataTableBuilder builder = PackageDataTable.builder();
            if(dto.get_id() != null){
                builder.id(dto.get_id());
            }
            return builder.tasked_unit(dto.getTasked_unit())
                    .prim_msn(dto.getPrim_msn())
                    .ac_type(dto.getAc_type())
                    .mission_num(dto.getMission_num())
                    .ac_cs(map(dto.getAc_cs()))
                    .pkg_id(dto.getPkg_id())
                    .num_ac(dto.getNum_ac())
                    .build();
        }
        return null;
    }
    private static List<GroundTargetLocationTable> mapGroundTargetLocations(List<GroundTargetLocation> gtgtloc) {
        if (gtgtloc != null && !gtgtloc.isEmpty()) {
            return gtgtloc.stream().map(EntityMapper::map).collect(Collectors.toList());
        }
        return null;

    }

    private static GroundTargetLocationTable map(GroundTargetLocation groundTargetLocation) {
        if (groundTargetLocation != null) {
            log.info("Converting GroundTargetLocation Dto to Entity");
            GroundTargetLocationTable.GroundTargetLocationTableBuilder builder = GroundTargetLocationTable.builder();
            if (groundTargetLocation.get_id() != null) {
                builder.id(groundTargetLocation.get_id());
            }
            return builder.tot(groundTargetLocation.getTot())
                    .nlt(groundTargetLocation.getNlt())
                    .target_id(groundTargetLocation.getTarget_id())
                    .net(groundTargetLocation.getNet())
                    .dmpi(map(groundTargetLocation.getDmpi()))
                    .priority(groundTargetLocation.getPriority())
                    .description(groundTargetLocation.getDescription())
                    .build();
        }
            return null;

    }

    private static CoordinateTable map(Coordinate dto) {
        if(dto != null){
            CoordinateTable.CoordinateTableBuilder builder = CoordinateTable.builder();
            if(dto.get_id() != null)
                builder.id(dto.get_id());
            return builder.elevation(dto.getElevation()).lat(dto.getLat()).lon(dto.getLon()).build();
        }
        return null;
    }

    public static List<FlightLineTable> mapFlightLines(List<FlightLine> lines) {
        return lines.stream().map(EntityMapper::map).collect(Collectors.toList());
    }

    public static PackageCommandTable map(PackageCommand dto) {
        if(dto != null) {
            PackageCommandTable.PackageCommandTableBuilder builder = PackageCommandTable.builder();
            if (dto.get_id() != null) {
                builder.id(dto.get_id());
            }
            return builder.pkg_cmdr_cs(map(dto.getPkg_cmdr_cs()))
                    .pkg_cmdr_unit_id(dto.getPkg_cmdr_unit_id())
                    .pkg_id(dto.getPkg_id())
                    .pkg_cmdr_mission_num(dto.getPkg_cmdr_mission_num())
                    .build();
        }
        return null;
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
            }else{
                builder.suffix01(null);
            }
            if (callsign.getSuffix().size() >= 2) {
                builder.suffix02(callsign.getSuffix().get(1));
            }
            else builder.suffix02(null);
            if (callsign.getSuffix().size() >= 3) {
                builder.suffix03(callsign.getSuffix().get(2));
            }else builder.suffix03(null);
            if (callsign.getSuffix().size() == 4) {
                builder.suffix04(callsign.getSuffix().get(3));
            }else builder.suffix04(null);
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
        if (location != null) {
            return AirMissionLocationTable.builder()
                    .location_name(location.getLocation_name())
                    .end_time(location.getEnd_time())
                    .start_time(location.getStart_time())
                    .msn_altitude(location.getMsn_altitude())
                    .build();
        }
        return null;
    }

    public static MissionDataTable map(MissionData dto) {
        MissionDataTable.MissionDataTableBuilder builder = MissionDataTable.builder()
                .prim_msn(dto.getPrim_msn())
                .num_ac(dto.getNum_ac())
                .mission_num(dto.getMission_num())
                .dep_location(map(dto.getDep_location()))
                .rec_location(map(dto.getRec_location()))
                .ac_type(dto.getAc_type())
                .sec_msn(dto.getSec_msn())
                .ac_cs(map(dto.getAc_cs()))
                .taskedUnit(dto.getTasked_unit());
                builder.mode_3(dto.getMode_3().stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
                    return builder.build();
    }

    public static BaseLocationTable map(BaseLocation table) {
        BaseLocationTable.BaseLocationTableBuilder builder = BaseLocationTable.builder();
        if (table.get_id() != null)
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




}


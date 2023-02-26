package miz.signup.mapper;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.extern.slf4j.Slf4j;
import miz.signup.dto.*;
import miz.signup.entities.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Slf4j
public class DtoMapper {
    public static Optional<ATO> map(Optional<AtoTable> airTaskingOrdersOptional) {
        if (airTaskingOrdersOptional.isPresent()) {
            return Optional.of(map(airTaskingOrdersOptional.get()));
        } else {
            return Optional.empty();
        }

    }

    public static Collection<ATO> map(Collection<AtoTable> airTaskingOrders) {
        return airTaskingOrders.stream().map(DtoMapper::map).collect(Collectors.toList());
    }

    public static ATO map(AtoTable airTaskingOrder) {
        return ATO.builder().header(AtoHeader.builder()
                        .identifier(airTaskingOrder.getIdentifier())
                        .name(airTaskingOrder.getName())
                        .time_from(map(airTaskingOrder.getTime_from()))
                        .time_to(map(airTaskingOrder.getTime_to()))
                        .documents(mapBriefing(airTaskingOrder.getDocuments()))
                        .timezone(airTaskingOrder.getTimezone())
                        .build())
                ._id(airTaskingOrder.getId())
                .lines(mapFlightLines(airTaskingOrder.getFlightLines()))
                .build();
    }

    public static List<BriefingDocument> mapBriefing(List<BriefingDocumentTable> briefingDocuments) {
        if (briefingDocuments != null && !briefingDocuments.isEmpty()) {
            return briefingDocuments.stream().map(DtoMapper::map).collect(Collectors.toList());
        }
        return null;
    }

    public static BriefingDocument map(BriefingDocumentTable briefingDocument) {
        if (briefingDocument != null) {
            BriefingDocument.BriefingDocumentBuilder builder = BriefingDocument.builder();
            if (briefingDocument.getId() != null) {
                builder._id(briefingDocument.getId());
            }
            return builder
                    .directory(briefingDocument.getDirectory())
                    .name(briefingDocument.getName())
                    .build();
        }
        return null;
    }

    public static DualZonedDateTime map(DualEndTimesTable endTime) {
        if (endTime != null) {
            DualZonedDateTime.DualZonedDateTimeBuilder builder = DualZonedDateTime.builder();
            if (endTime.getId() != null) {
                builder
                        ._id(endTime.getId());
            }
            return builder.ingame(endTime.getIngame())
                    .outgame(endTime.getOutgame())
                    .build();

        }
        return null;
    }

    public static DualZonedDateTime map(DualStartTimesTable endTime) {
        if (endTime != null) {
            DualZonedDateTime.DualZonedDateTimeBuilder builder = DualZonedDateTime.builder();
            if (endTime.getId() != null) {
                builder._id(endTime.getId());
            }
            return builder
                    .ingame(endTime.getIngame())
                    .outgame(endTime.getOutgame())
                    .build();
        }
        return null;
    }

    public static List<FlightLine> mapFlightLines(List<FlightLineTable> lines) {
        if (lines != null && !lines.isEmpty()) {
            return lines.stream().map(DtoMapper::map).collect(Collectors.toList());
        }
        return null;
    }

    public static FlightLine map(FlightLineTable lines) {
        return FlightLine.builder()
                ._id(lines.getId())
                .amsnloc(map(lines.getAmsnloc()))
                .gtgtloc(map(lines.getGtgtloc()))
                .arinfo(map(lines.getArinfo()))
                .pkgcmd(map(lines.getPkgcmd()))
                .pkgdat(mapPackageDatas(lines.getPkgdat()))
                .msndat(map(lines.getMsndat()))
                .build();
    }

    private static List<PackageData> mapPackageDatas(List<PackageDataTable> entities) {
        if(entities != null && !entities.isEmpty()){
            return entities.stream().map(DtoMapper::map).collect(Collectors.toList());
        }
        return null;
    }

    private static PackageData map(PackageDataTable entity) {
        if(entity != null){

            PackageData.PackageDataBuilder builder = PackageData.builder();
            if(entity.getId() != null){
                builder._id(entity.getId());
            }
            return builder.ac_cs(map(entity.getAc_cs()))
                    .mission_num(entity.getMission_num())
                    .prim_msn(entity.getPrim_msn())
                    .ac_type(entity.getAc_type())
                    .tasked_unit(entity.getTasked_unit())
                    .build();
        }
        return null;
    }

    private static PackageCommand map(PackageCommandTable entity) {
        if(entity != null){
            PackageCommand.PackageCommandBuilder builder = PackageCommand.builder();
            if(entity.getId() != null){
                builder._id(entity.getId());
            }
            return builder.pkg_cmdr_cs(map(entity.getPkg_cmdr_cs()))
                    .pkg_cmdr_mission_num(entity.getPkg_cmdr_mission_num())
                    .pkg_cmdr_unit_id(entity.getPkg_cmdr_unit_id())
                    .pkg_id(entity.getPkg_id()).build();
        }
        return null;
    }

    private static List<GroundTargetLocation> map(List<GroundTargetLocationTable> gtgtloc) {
        if (gtgtloc != null && !gtgtloc.isEmpty()) {
            return gtgtloc.stream().map(DtoMapper::map).collect(Collectors.toList());
        }
        return null;

    }

    public static GroundTargetLocation map(GroundTargetLocationTable entity) {
        GroundTargetLocation.GroundTargetLocationBuilder builder = GroundTargetLocation.builder();
        if (entity.getId() != null) {
            builder._id(entity.getId());
        }
        builder.description(entity.getDescription())
                .priority(entity.getPriority())
                .target_id(entity.getTarget_id())
                .nlt(entity.getNlt())
                .dmpi(map(entity.getDmpi()))
                .net(entity.getNet())
                .tot(entity.getTot());

        return builder.build();
    }

    private static Coordinate map(CoordinateTable entity) {
        if (entity != null) {
            Coordinate.CoordinateBuilder builder = Coordinate.builder();
            if (entity.getId() != null) {
                builder._id(entity.getId());
            }
            return builder.elevation(entity.getElevation())
                    .lat(entity.getLat())
                    .lon(entity.getLon())
                    .build();
        }
        return null;
    }

    public static Frequency map(FrequencyTable entity) {
        return Frequency.builder()
                ._id(entity.getId())
                .freq(entity.getFreq())
                .name(entity.getName())
                .build();
    }

    public static MissionData map(MissionDataTable table) {
        MissionData.MissionDataBuilder builder = MissionData.builder();
        if (table.getId() != null)
            builder._id(table.getId());
        builder.dep_location(map(table.getDep_location()))
                .rec_location(map(table.getRec_location()))
                .ac_cs(map(table.getAc_cs()))
                .ac_type(table.getAc_type())
                .prim_msn(table.getPrim_msn())
                .sec_msn(table.getSec_msn())
                .num_ac(table.getNum_ac())
                .tasked_unit(table.getTaskedUnit())
                .mission_num(table.getMission_num())
        ;

        return builder.build();
    }

    public static BaseLocation map(BaseLocationTable table) {
        if (table != null) {
            BaseLocation.BaseLocationBuilder builder = BaseLocation.builder();
            if (table.getId() != null) {
                builder._id(table.getId());
            }
            builder.name(table.getName()).icao(table.getIcao());

            return builder.build();
        } else {
            return null;
        }
    }

    public static AirRefuelInfo map(AirRefuelInfoTable airRefuelInfoTable) {
        return AirRefuelInfo.builder()
                ._id(airRefuelInfoTable.getId())
                .ac_type(airRefuelInfoTable.getAc_type())
                .frequency(map(airRefuelInfoTable.getFrequency()))
                .offload(airRefuelInfoTable.getOffload())
                .refuel_system(airRefuelInfoTable.getRefule_system())
                .tacan(airRefuelInfoTable.getTacan())
                .tnkr_alt(airRefuelInfoTable.getTnkr_alt())
                .tnkr_cp(airRefuelInfoTable.getTnkr_cp())
                .tnkr_cs(map(airRefuelInfoTable.getTnkr_cs()))
                .build();
    }

    public static Callsign map(CallsignTable callsignTable) {
        if (callsignTable != null)
            return Callsign.builder()
                    ._id(callsignTable.getId())
                    .prefix(callsignTable.getPrefix())
                    .suffix(Arrays.asList(callsignTable.getSuffix01(), callsignTable.getSuffix02(), callsignTable.getSuffix03(), callsignTable.getSuffix04()))
                    .build();
        else return null;
    }

    public static AirMissionLocation map(AirMissionLocationTable location) {
        if (location != null)
            return AirMissionLocation.builder()
                    ._id(location.getId())
                    .msn_altitude(location.getMsn_altitude())
                    .end_time(location.getEnd_time())
                    .start_time(location.getStart_time())
                    .location_name(location.getLocation_name())
                    .build();
        else return null;
    }

}

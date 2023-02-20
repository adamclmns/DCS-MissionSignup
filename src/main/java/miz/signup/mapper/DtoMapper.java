package miz.signup.mapper;

import miz.signup.dto.*;
import miz.signup.entities.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                .lines(map(airTaskingOrder.getFlightLines()))
                .build();
    }

    public static List<BriefingDocument> mapBriefing(List<BriefingDocumentTable> briefingDocuments) {
        if(briefingDocuments != null && !briefingDocuments.isEmpty()) {
            return briefingDocuments.stream().map(DtoMapper::map).collect(Collectors.toList());
        }
        return null;
    }

    public static BriefingDocument map(BriefingDocumentTable briefingDocument) {
        if(briefingDocument != null ) {
            BriefingDocument.BriefingDocumentBuilder builder = BriefingDocument.builder();
            if(briefingDocument.getId() != null) {
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
        if(endTime != null) {
            DualZonedDateTime.DualZonedDateTimeBuilder builder = DualZonedDateTime.builder();
            if(endTime.getId()!= null) {
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
        if(endTime != null) {
            DualZonedDateTime.DualZonedDateTimeBuilder builder =  DualZonedDateTime.builder();
            if(endTime.getId() != null){
                builder._id(endTime.getId());
            }
            return builder
                    .ingame(endTime.getIngame())
                    .outgame(endTime.getOutgame())
                    .build();
        }
        return null;
    }

    public static List<FlightLine> map(List<FlightLineTable> lines) {
        return lines.stream().map(DtoMapper::map).collect(Collectors.toList());
    }

    public static FlightLine map(FlightLineTable lines) {
        return FlightLine.builder()
                ._id(lines.getId())
                .amsnloc(map(lines.getAmsnloc()))
                .arinfo(map(lines.getArinfo()))
                .build();
    }

    public static Frequency map(FrequencyTable frequencyTable) {
        return Frequency.builder()
                ._id(frequencyTable.getId())
                .freq(frequencyTable.getFreq())
                .name(frequencyTable.getName())
                .build();
    }

    public static AirRefuelInfo map(AirRefuelInfoTable airRefuelInfoTable) {
        return AirRefuelInfo.builder()
                ._id(airRefuelInfoTable.getId())
                .ac_type(airRefuelInfoTable.getAc_type())
                .frequency(map(airRefuelInfoTable.getFrequency()))
                .offload(airRefuelInfoTable.getOffload())
                .refule_system(airRefuelInfoTable.getRefule_system())
                .tacan(airRefuelInfoTable.getTacan())
                .tnkr_alt(airRefuelInfoTable.getTnkr_alt())
                .tnkr_cp(airRefuelInfoTable.getTnkr_cp())
                .tnkr_cs(map(airRefuelInfoTable.getTnkr_cs()))
                .build();
    }

    public static Callsign map(CallsignTable callsignTable) {
        if(callsignTable != null)
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

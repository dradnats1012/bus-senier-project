package koreatechBus.dto.station;

public record RegisterStationDTO(
    Long busId,
    String stationName,
    String arrivalTime
) {

}

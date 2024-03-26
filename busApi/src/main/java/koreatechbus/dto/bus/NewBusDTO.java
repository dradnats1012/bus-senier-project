package koreatechBus.dto.bus;

import java.util.List;

import koreatechBus.enums.Days;
public record NewBusDTO(
    String name,
    String departTime,
    String arrivalTime,
    List<Days> runDays
) {
}

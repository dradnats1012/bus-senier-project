package koreatechBus.service;

import org.springframework.stereotype.Service;

import koreatechBus.domain.Bus;
import koreatechBus.domain.Station;
import koreatechBus.dto.station.RegisterStationDTO;
import koreatechBus.repository.BusRepository;
import koreatechBus.repository.StationRepository;

@Service
public class StationService {
    private final StationRepository stationRepository;
    private final BusRepository busRepository;

    public StationService(StationRepository stationRepository, BusRepository busRepository) {
        this.stationRepository = stationRepository;
        this.busRepository = busRepository;
    }

    public Station registerStation(RegisterStationDTO registerStationDTO) {
        Bus bus = busRepository.findByBusId(registerStationDTO.busId());

        Station station = Station.builder()
            .stationName(registerStationDTO.stationName())
            .arrivalTime(registerStationDTO.arrivalTime())
            .bus(bus)
            .build();

        stationRepository.save(station);

        return station;
    }
}

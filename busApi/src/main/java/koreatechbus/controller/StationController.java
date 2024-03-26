package koreatechbus.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import koreatechbus.domain.Station;
import koreatechbus.dto.station.RegisterStationDTO;
import koreatechbus.service.StationService;

@RestController
@RequestMapping("/station")
public class StationController {
    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping("/register")
    public Station registerStation(
        @RequestBody RegisterStationDTO registerStationDTO
    ) {
        return stationService.registerStation(registerStationDTO);
    }
}

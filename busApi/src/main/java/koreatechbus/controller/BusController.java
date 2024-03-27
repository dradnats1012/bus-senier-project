package koreatechbus.controller;

import koreatechbus.domain.Bus;
import koreatechbus.dto.bus.BusDTO;
import koreatechbus.dto.bus.GetBusDTO;
import koreatechbus.dto.bus.NewBusDTO;
import koreatechbus.service.BusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {
    private final BusService busService;

    public BusController(BusService busService){
        this.busService = busService;
    }

    @GetMapping()
    public List<BusDTO> getAllBus(){
        return busService.getAllBus();
    }

    @PostMapping
    public Bus putBus(@RequestBody NewBusDTO newBusDTO){
        return busService.putBus(newBusDTO);
    }

    @GetMapping("/{busId}")
    public GetBusDTO getBusById(
        @PathVariable("busId") Long busId
    ){
        return busService.getBusById(busId);
    }
}

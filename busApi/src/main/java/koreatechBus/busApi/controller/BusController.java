package koreatechBus.busApi.controller;

import koreatechBus.busApi.service.BusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {
    private final BusService busService;

    public BusController(BusService busService){
        this.busService = busService;
    }

    public List<String> getAllBus(){
        return busService.getAllBus();
    }
}

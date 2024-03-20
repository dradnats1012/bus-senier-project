package koreatechBus.busApi.service;

import koreatechBus.busApi.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {
    private final BusRepository busRepository;

    public BusService(BusRepository busRepository){
        this.busRepository = busRepository;
    }

    public List<String> getAllBus(){
        return busRepository.findAllBusNames();
    }
}

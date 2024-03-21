package koreatechBus.service;

import koreatechBus.domain.Bus;
import koreatechBus.dto.bus.NewBusDTO;
import koreatechBus.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BusService {
    private final BusRepository busRepository;
    private final Long MANAGER_ROLE_NUM = 1L;
    public BusService(BusRepository busRepository){
        this.busRepository = busRepository;
    }

    public List<String> getAllBus(){
        return busRepository.findAllBusNames();
    }

    public Bus putBus(NewBusDTO newBusDTO){
        return busRepository.save(Bus.builder()
                .name(newBusDTO.getName())
                .departTime(newBusDTO.getDepartTime())
                .arrivalTime(newBusDTO.getArrivalTime())
                .build());
    }

    private void isManager(Long role){
        if(!Objects.equals(role, MANAGER_ROLE_NUM)){
            throw new IllegalArgumentException("권한이 없습니다!");
        }
    }
}

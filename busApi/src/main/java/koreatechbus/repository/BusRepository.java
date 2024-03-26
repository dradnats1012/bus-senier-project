package koreatechbus.repository;

import koreatechbus.domain.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Long> {
    @Query("SELECT b.name FROM Bus b")
    List<String> findAllBusNames();

    Bus findByBusId(Long busId);
}

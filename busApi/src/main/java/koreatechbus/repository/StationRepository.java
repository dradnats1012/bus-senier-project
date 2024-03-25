package koreatechBus.repository;

import koreatechBus.domain.Station;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
    Station save(Station station);
}

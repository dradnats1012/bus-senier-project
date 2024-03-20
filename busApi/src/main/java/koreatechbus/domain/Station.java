package koreatechbus.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "station")
@Getter
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id")
    private Long stationId;

    @Column(name = "station_name")
    private String stationName;

    @Column(name = "arrival_time")
    private String arrivalTime;


}

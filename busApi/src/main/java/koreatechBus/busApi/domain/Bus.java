package koreatechBus.busApi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "bus")
@Getter
public class Bus {

    @Id
    @Column(name = "bus_id")
    private Long busId;

    @Column(name = "depart_Time")
    private String departTime;

    @Column(name = "arrival_Time")
    private String arrivalTime;

    @Column(name = "passengers")
    private Long passengers;

    @Column(name = "bookmark_num")      // 북마크로 등록한 사용자 수
    private Long bookmarkNum;
}

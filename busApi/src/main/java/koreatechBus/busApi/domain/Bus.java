package koreatechBus.busApi.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bus")
@Getter
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long busId;

    @Column(name = "name")
    private String name;

    @Column(name = "depart_Time")
    private String departTime;

    @Column(name = "arrival_Time")
    private String arrivalTime;

    @Column(name = "passengers")
    private Long passengers;

    @Column(name = "bookmark_num")      // 북마크로 등록한 사용자 수
    private Long bookmarkNum;

    @OneToMany(mappedBy = "bus")
    private Set<Bookmark> bookmarks = new HashSet<>();
}
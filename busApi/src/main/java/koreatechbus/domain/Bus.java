package koreatechBus.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.HashSet;
import java.util.Locale;
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

    @Builder
    public Bus(String name, String departTime, String arrivalTime){
        this.name = name;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
    }

    @PrePersist
    public void prePersist() {
        if (passengers == null) passengers = 0L;
        if (bookmarkNum == null) bookmarkNum = 0L;
    }
}

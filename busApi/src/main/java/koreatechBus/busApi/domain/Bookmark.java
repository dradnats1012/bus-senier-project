package koreatechBus.busApi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "bookmark")
@Getter
public class Bookmark {

    @Id
    @Column(name = "bookmark_id")
    private Long bookmarkId;


}

package koreatechBus.busApi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "post")
@Getter
public class Post {

    @Id
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "post_time")
    private String postTime;

    @Column(name = "post_type")
    private Long postType;
}

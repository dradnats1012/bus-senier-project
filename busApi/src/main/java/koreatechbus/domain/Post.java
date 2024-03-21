package koreatechbus.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "post")
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "post_time")
    private String postTime;

    @Column(name = "post_type") // 1 : 공지사항, 2 : 분실물, 3 : 자유
    private Long postType;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
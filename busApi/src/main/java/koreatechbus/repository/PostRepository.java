package koreatechbus.repository;

import java.util.List;

import koreatechbus.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post save(Post post);

    Post findByPostId(Long postId);

    List<Post> findByPostType(Long postType);
}

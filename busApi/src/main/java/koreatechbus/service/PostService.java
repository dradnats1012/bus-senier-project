package koreatechbus.service;

import org.springframework.stereotype.Service;

import koreatechbus.domain.Post;
import koreatechbus.domain.User;
import koreatechbus.dto.post.RequestPostDTO;
import koreatechbus.repository.PostRepository;
import koreatechbus.repository.UserRepository;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public void newPost(RequestPostDTO requestPostDTO){
        User user = userRepository.findByUserId(requestPostDTO.userId());

        Post post = Post.builder()
            .title(requestPostDTO.title())
            .content(requestPostDTO.content())
            .postTime(requestPostDTO.postTime())
            .postType(requestPostDTO.postType())
            .user(user)
            .build();

        postRepository.save(post);
    }
}

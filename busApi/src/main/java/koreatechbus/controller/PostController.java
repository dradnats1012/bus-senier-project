package koreatechbus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import koreatechbus.dto.post.RequestPostDTO;
import koreatechbus.dto.post.ResponsePostDTO;
import koreatechbus.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Void> newPost(
        @RequestBody RequestPostDTO requestPostDTO
    ){
        postService.newPost(requestPostDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ResponsePostDTO> getPostById(
        @PathVariable Long postId
    ){
        postService.getPostById(postId);
        return ResponseEntity.ok().body(postService.getPostById(postId));
    }
}

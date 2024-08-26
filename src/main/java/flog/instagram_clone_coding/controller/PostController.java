package flog.instagram_clone_coding.controller;

import flog.instagram_clone_coding.domain.Post;
import flog.instagram_clone_coding.domain.Users;
import flog.instagram_clone_coding.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Post", description = "Post API")
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/api/posts/users/{userId}")
    @Operation(summary = "특정 사용자의 모든 게시물 조회")
    public List<Post> getPostsByUser(@PathVariable Long userId) {
        Users user = new Users();
        user.setId(userId);
        return postService.getPostByUser(user);
    }

    @PostMapping("/api/posts")
    @Operation(summary = "게시물 작성")
    public ResponseEntity<Post> createPost(@RequestParam Long userId, @RequestBody String content) {
        Users user = new Users();
        user.setId(userId);
        Post newPost = postService.createPost(user, content);
        return ResponseEntity.ok(newPost);
    }

    @DeleteMapping("/api/posts/{postId}")
    @Operation(summary = "특정 게시물 삭제")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}

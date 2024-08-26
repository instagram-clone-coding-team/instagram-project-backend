package flog.instagram_clone_coding.service;

import flog.instagram_clone_coding.domain.Post;
import flog.instagram_clone_coding.domain.Users;
import flog.instagram_clone_coding.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getPostByUser(Users user) {
        return postRepository.findByUser(user);
    }

    public Post createPost(Users user, String content) {
        Post post = Post.builder()
                .user(user)
                .content(content)
                .build();
        return postRepository.save(post);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}

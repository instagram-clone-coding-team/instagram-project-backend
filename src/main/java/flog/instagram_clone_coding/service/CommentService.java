package flog.instagram_clone_coding.service;

import flog.instagram_clone_coding.domain.Comment;
import flog.instagram_clone_coding.domain.Post;
import flog.instagram_clone_coding.domain.Users;
import flog.instagram_clone_coding.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentByPost(Post post) {
        return commentRepository.findByPost(post);
    }

    public Comment addCommentToPost(Post post, Users user, String content) {
        Comment comment = Comment.builder()
                .post(post)
                .user(user)
                .content(content)
                .build();
        return commentRepository.save(comment);
    }

    public List<Comment> getRepliesByComment(Comment parentComment) {
        return commentRepository.findByParentComment(parentComment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}

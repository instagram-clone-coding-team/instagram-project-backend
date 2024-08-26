package flog.instagram_clone_coding.repository;

import flog.instagram_clone_coding.domain.Comment;
import flog.instagram_clone_coding.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 특정 게시물에 속한 댓글 목록 조회
    List<Comment> findByPost(Post post);

    // 특정 상위 댓글에 속한 대댓글 목록 조회
    List<Comment> findByParentComment(Comment parentComment);
}

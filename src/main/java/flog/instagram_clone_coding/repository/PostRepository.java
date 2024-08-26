package flog.instagram_clone_coding.repository;

import flog.instagram_clone_coding.domain.Post;
import flog.instagram_clone_coding.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // 특정 사용자가 작성한 게시물 목록 조회
    List<Post> findByUser(Users user);
}

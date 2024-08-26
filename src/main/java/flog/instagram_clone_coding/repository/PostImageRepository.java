package flog.instagram_clone_coding.repository;

import flog.instagram_clone_coding.domain.PostImage;
import flog.instagram_clone_coding.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostImageRepository extends JpaRepository<PostImage, Long> {

    // 특정 게시물에 속한 이미지 목록 조회
    List<PostImage> findByPost(Post post);
}

package flog.instagram_clone_coding.repository;

import flog.instagram_clone_coding.domain.Likes;
import flog.instagram_clone_coding.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Likes, Long> {

    // 특정 대상에 대한 좋아요 목록 조회
    List<Likes> findByLikeTypeAndTargetId(String likeType, Long targetId);

    // 특정 사용자가 좋아요한 기록 조회
    List<Likes> findByUser(Users user);
}

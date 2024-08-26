package flog.instagram_clone_coding.repository;

import flog.instagram_clone_coding.domain.Bookmark;
import flog.instagram_clone_coding.domain.Post;
import flog.instagram_clone_coding.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    // 특정 사용자가 북마크한 게시물 목록 조회
    List<Bookmark> findByUser(Users user);

    // 특정 게시물을 북마크한 목록 조회
    List<Bookmark> findByPost(Post post);
}

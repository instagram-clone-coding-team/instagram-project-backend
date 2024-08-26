package flog.instagram_clone_coding.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmarkId;

    @Column
    private LocalDateTime bookmarkedAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post post;     // 북마크된 게시물

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Users user;     // 북마크한 사용자
}

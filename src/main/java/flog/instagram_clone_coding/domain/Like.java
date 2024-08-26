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
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @Column
    private String likeType;        // 좋아요 유형 (게시물인지 댓글인지)

    @Column
    private Long targetId;          // 게시물 ID or 댓글 ID

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Users user;             // 좋아요를 누른 사용자
}

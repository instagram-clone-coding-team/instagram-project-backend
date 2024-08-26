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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column
    private String content;

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post post;                 // 댓글이 달린 게시물

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Users user;                 // 댓글 작성자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Comment parentComment;      // 대댓글인 경우, 상위 댓글
}

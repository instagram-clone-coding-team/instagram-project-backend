package flog.instagram_clone_coding.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postImageId;

    @Column
    private String postImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post post;     // 이미지가 속한 게시물
}

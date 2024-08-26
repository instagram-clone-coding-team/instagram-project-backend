package flog.instagram_clone_coding.service;

import flog.instagram_clone_coding.domain.PostImage;
import flog.instagram_clone_coding.domain.Post;
import flog.instagram_clone_coding.repository.PostImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostImageService {

    @Autowired
    private PostImageRepository postImageRepository;

    public List<PostImage> getImageByPost(Post post) {
        return postImageRepository.findByPost(post);
    }

    public PostImage addImageToPost(Post post, String imageUrl) {
        PostImage postImage = PostImage.builder()
                .post(post)
                .postImageUrl(imageUrl)
                .build();
        return postImageRepository.save(postImage);
    }

    public void deleteImage(Long postImageId) {
        postImageRepository.deleteById(postImageId);
    }
}

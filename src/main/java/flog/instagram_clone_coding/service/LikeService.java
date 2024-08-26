package flog.instagram_clone_coding.service;

import flog.instagram_clone_coding.domain.Likes;
import flog.instagram_clone_coding.domain.Users;
import flog.instagram_clone_coding.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public List<Likes> getLikesByUser(Users user) {
        return likeRepository.findByUser(user);
    }

    public List<Likes> getLikesByTarget(String likeType, Long targetId) {
        return likeRepository.findByLikeTypeAndTargetId(likeType, targetId);
    }

    public Likes addLike(Users user, String likeType, Long targetId) {
        Likes like = Likes.builder()
                .user(user)
                .likeType(likeType)
                .targetId(targetId)
                .build();
        return likeRepository.save(like);
    }

    public void deleteLike(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}

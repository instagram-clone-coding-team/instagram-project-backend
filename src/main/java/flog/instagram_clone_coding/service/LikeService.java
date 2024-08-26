package flog.instagram_clone_coding.service;

import flog.instagram_clone_coding.domain.Like;
import flog.instagram_clone_coding.domain.Users;
import flog.instagram_clone_coding.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public List<Like> getLikesByUser(Users user) {
        return likeRepository.findByUser(user);
    }

    public List<Like> getLikesByTarget(String likeType, Long targetId) {
        return likeRepository.findByLikeTypeAndTargetId(likeType, targetId);
    }

    public Like addLike(Users user, String likeType, Long targetId) {
        Like like = Like.builder()
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

package com.example.socialmediaproject.services;

import com.example.socialmediaproject.entities.Like;
import com.example.socialmediaproject.repositories.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LikeService {


    private LikeRepository likeRepository;

    LikeService(LikeRepository likeRepository){

    this.likeRepository=likeRepository;}




    public Optional<Like> findById(Long likeId) {
        return likeRepository.findById(likeId);

    }

    public String delete(Long likeId) {
        Optional<Like> like = likeRepository.findById(likeId);
        if (like.isPresent()) {
            likeRepository.delete(like.get());
            return "Kaldırma işlemi başarılı";
        } else {
            return "Kaldırılacak beğeni bulunamadı";

    }


    }
    public Like save(Like like) {

        return  likeRepository.save(like);
    }
    public List<Like> findByUserId(Long userId) {
        return likeRepository.findByUserId(userId);
    }
}

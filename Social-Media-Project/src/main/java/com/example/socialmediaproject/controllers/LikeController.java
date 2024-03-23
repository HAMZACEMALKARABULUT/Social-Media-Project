package com.example.socialmediaproject.controllers;



import com.example.socialmediaproject.entities.Like;

import com.example.socialmediaproject.repositories.LikeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {

    private LikeRepository likeRepository;

    LikeController(LikeRepository likeRepository){

        this.likeRepository=likeRepository;
    }




    //---------------------------------------------------------------------
    @PostMapping
    public Like likePost(@RequestBody Like like) {
        return likeRepository.save(like);

    }

    //---------------------------------------------------------------------
    @DeleteMapping("/{likeId}")
    public String removeLike(@PathVariable Long likeId) {
        Optional<Like> like = likeRepository.findById(likeId);
        if (like.isPresent()) {
            likeRepository.delete(like.get());
            return "Kaldırma işlemi başarılı";
        } else {
            return "Kaldırılacak beğeni bulunamadı";
        }
    }

    //---------------------------------------------------------------------
    @GetMapping("/{likeId}")
    public Like getLike(@PathVariable Long likeId) {
        Optional<Like> like = likeRepository.findById(likeId);
        if (like.isPresent()) {
            return like.get();
        } else {
            return null;
        }

    }

    //---------------------------------------------------------------------
    @GetMapping("/user/{userId}")
    public List<Like> getAllLikesByUser(@PathVariable Long userId){
        return likeRepository.findByUserId(userId);
    }


}



package com.example.socialmediaproject.controllers;



import com.example.socialmediaproject.entities.Like;

import com.example.socialmediaproject.services.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {

    private LikeService likeService;

    LikeController(LikeService likeService){

        this.likeService=likeService;
    }


    //---------------------------------------------------------------------
    @PostMapping
    public Like likePost(@RequestBody Like like) {
        return likeService.save(like);

    }


    //---------------------------------------------------------------------
    @DeleteMapping("/{likeId}")
    public String removeLike(@PathVariable Long likeId) {
       return likeService.delete(likeId);
        }



    //---------------------------------------------------------------------
    @GetMapping("/{likeId}")
    public Like getLike(@PathVariable Long likeId) {
      return likeService.findById(likeId);
    }

    //---------------------------------------------------------------------
    @GetMapping("/user/{userId}")
    public List<Like> getAllLikesByUser(@PathVariable Long userId){
        return likeService.findByUserId(userId);
    }


}



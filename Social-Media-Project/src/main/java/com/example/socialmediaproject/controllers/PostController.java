package com.example.socialmediaproject.controllers;

import com.example.socialmediaproject.entities.Post;
import com.example.socialmediaproject.repositories.PostRepository;
import com.example.socialmediaproject.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {


    private PostService postService;

    PostController(PostService postService) {
        this.postService = postService;
    }


    //----------------------------------------------------------
    @PostMapping
    public Post createPost(@RequestBody Post post) {

        return postService.save(post);

    }

    //----------------------------------------------------------
    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Long postId) {
   return postService.delete(postId);

    }



    //----------------------------------------------------------


    @GetMapping("/{postId}")
    public Post getPost(@PathVariable Long postId) {
            return postService.findById(postId);
    }

    //----------------------------------------------------------
    @GetMapping("/user/{userId}")
    public List<Post>  getPostsByUserId(@PathVariable Long userId){

        return postService.findByUserId(userId);
    }

    //----------------------------------------------------------




}

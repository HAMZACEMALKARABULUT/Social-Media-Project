package com.example.socialmediaproject.controllers;

import com.example.socialmediaproject.entities.Post;
import com.example.socialmediaproject.repositories.PostRepository;
import com.example.socialmediaproject.requests.PostCreateRequest;
import com.example.socialmediaproject.requests.PostUpdateRequest;
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
    public Post createPost(@RequestBody PostCreateRequest post) {

        return postService.createOneUser(post);
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
    @GetMapping()
    public List<Post>  getPostsByUserId(@RequestParam Long userId){

        return postService.findByUserId(userId);
    }

    //----------------------------------------------------------


    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest postToUpdate){


        return postService.updatePostById(postId,postToUpdate);
    }

}

package com.example.socialmediaproject.controllers;

import com.example.socialmediaproject.entities.Post;
import com.example.socialmediaproject.repositories.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {


    private PostRepository postRepository;

    PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //----------------------------------------------------------
    @PostMapping
    public Post createPost(@RequestBody Post post) {

        return postRepository.save(post);

    }

    //----------------------------------------------------------
    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Long postId) {

        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {

            postRepository.delete(post.get());
            return "Post silindi";
        } else {
            return "Post bulunamadı";
        }
    }

    //----------------------------------------------------------

    @GetMapping("/{postId}")
    public Post getPost(@PathVariable Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            return post.get();
        } else {
            return null;
        }

    }
    //----------------------------------------------------------
    @GetMapping("/user/{userId}")
    public List<Post>  getPostsByUserId(@PathVariable Long userId){

        return postRepository.findByUserId(userId);
    }

    //----------------------------------------------------------




}

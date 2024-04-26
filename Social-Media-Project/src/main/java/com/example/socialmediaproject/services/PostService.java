package com.example.socialmediaproject.services;

import com.example.socialmediaproject.entities.Post;
import com.example.socialmediaproject.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostService {

    private PostRepository postRepository;

    PostService(PostRepository postRepository){
        this.postRepository=postRepository;

    }
    public Post save(Post post) {
      return postRepository.save(post);


    }

    public Post findById(Long postId) {

        Optional<Post> post = postRepository.findById(postId);

        if (post.isPresent()) {
            return post.get();
        } else {
            return null;
        }


    }

    public List<Post> findByUserId(Long userId) {

        return postRepository.findByUserId(userId);

    }

    public String delete(Long postId) {


        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {

            postRepository.delete(post.get());
            return "Post silindi";
        } else {
            return "Post bulunamadı";
        }

    }
}

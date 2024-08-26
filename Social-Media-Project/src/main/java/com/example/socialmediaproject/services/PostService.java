package com.example.socialmediaproject.services;

import com.example.socialmediaproject.entities.Post;
import com.example.socialmediaproject.entities.User;
import com.example.socialmediaproject.repositories.PostRepository;
import com.example.socialmediaproject.requests.PostCreateRequest;
import com.example.socialmediaproject.requests.PostUpdateRequest;
import com.example.socialmediaproject.services.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostService {

    private PostRepository postRepository;
    private UserService userService;


    PostService(PostRepository postRepository,UserService userService){
        this.postRepository=postRepository;
        this.userService=userService;
    }


    public Post createOneUser(PostCreateRequest newPostRequest){
        Optional<User> user=userService.findById(newPostRequest.getUserId());
        if(user.isPresent()){
// This method is temporary . The mapper methods will be changed.

            Post toSave=new Post();
            toSave.setUser(user.get());
            toSave.setText(newPostRequest.getText());
            toSave.setTitle(newPostRequest.getTitle());

            return postRepository.save(toSave);}


        else throw(new CustomException("Kullanıcı bulunamadı"));

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

    public Post updatePostById(Long postId, PostUpdateRequest postToUpdate) {

        Post post =findById(postId);
        if(post!= null){

            post.setTitle(postToUpdate.getTitle());
            post.setText(postToUpdate.getText());
           return postRepository.save(post);

        }
else{
            throw(new CustomException("Bu id'ye sahip bir post bulunmamaktadır"));
        }

    }
}

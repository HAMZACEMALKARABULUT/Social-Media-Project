package com.example.socialmediaproject.services;

import com.example.socialmediaproject.entities.Comment;
import com.example.socialmediaproject.entities.Post;
import com.example.socialmediaproject.entities.User;
import com.example.socialmediaproject.repositories.CommentRepository;
import com.example.socialmediaproject.requests.CommentCreateRequest;
import com.example.socialmediaproject.services.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {


    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;


    CommentService(CommentRepository commentRepository , UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.postService=postService;
        this.userService=userService;
    }

    public Comment findById(Long commentId) {

        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            return comment.get();
        } else {
            throw (new CustomException("Yorum bulunamadı"));
        }
    }

    public Comment createComment(CommentCreateRequest comment) {



            User user=userService.findById(comment.getUserId()).get();

            Post post =postService.findById(comment.getPostId());

            if(post!=null&&user!=null){
                Comment comment1=new Comment();
                comment1.setText(comment.getText());
                comment1.setPost(post);
                comment1.setUser(user);

                return commentRepository.save(comment1);

            }
            else{
                throw(new CustomException("Alanlar boş."));}
    }

    public String delete(Long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            commentRepository.delete(comment.get());
            return "Silme işlemi başarılı";
        } else {
            return "Silinecek yorum bulunamadı";
        }

    }


    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {

        if (postId.isPresent() && userId.isEmpty()) {
            return commentRepository.findByPostId(postId.get());
        } else if (userId.isPresent() && postId.isEmpty()) {
            return commentRepository.findByUserId(userId.get());
        } else if (userId.isEmpty() && postId.isEmpty()) {
            return commentRepository.findAll();
        } else throw (new CustomException(("Bu istek bir sonuç getirmedi")));
    }
}

package com.example.socialmediaproject.controllers;


import com.example.socialmediaproject.entities.Comment;
import com.example.socialmediaproject.repositories.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/comments")
public class CommentController {

    //---------------------------------------------------------------------
    private CommentRepository commentRepository;

    CommentController(CommentRepository commentRepository) {

        this.commentRepository = commentRepository;
    }

    //---------------------------------------------------------------------
    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);

    }

    //---------------------------------------------------------------------
    @DeleteMapping("/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            commentRepository.delete(comment.get());
            return "Silme işlemi başarılı";
        } else {
            return "Silinecek yorum bulunamadı";
        }
    }

    //---------------------------------------------------------------------
    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable Long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            return comment.get();
        } else {
            return null;


        }

    }

    //---------------------------------------------------------------------
    @GetMapping
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }


}

package com.example.socialmediaproject.controllers;


import com.example.socialmediaproject.entities.Comment;
import com.example.socialmediaproject.repositories.CommentRepository;
import com.example.socialmediaproject.requests.CommentCreateRequest;
import com.example.socialmediaproject.services.CommentService;
import com.example.socialmediaproject.services.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/comments")
public class CommentController {

    //---------------------------------------------------------------------
    private CommentService commentService;


    CommentController(CommentService commentService) {

        this.commentService = commentService;
    }

    //---------------------------------------------------------------------
    @PostMapping
    public Comment createComment(@RequestBody CommentCreateRequest comment) {

        return commentService.createComment(comment);

    }

    //---------------------------------------------------------------------
    @DeleteMapping("/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        return commentService.delete(commentId);
    }


    //---------------------------------------------------------------------
    @GetMapping("/{commentId}")

    public Comment getComment(@PathVariable Long commentId) {
        return commentService.findById(commentId);

    }

    //---------------------------------------------------------------------
    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
     return commentService.getAllCommentsWithParam(userId,postId);

    }


}

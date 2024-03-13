package com.example.socialmediaproject.repositories;

import com.example.socialmediaproject.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}

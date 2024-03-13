package com.example.socialmediaproject.repositories;

import com.example.socialmediaproject.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {
}

package com.example.socialmediaproject.repositories;

import com.example.socialmediaproject.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LikeRepository extends JpaRepository<Like,Long> {
    List<Like> findByUserId(Long userId);
}

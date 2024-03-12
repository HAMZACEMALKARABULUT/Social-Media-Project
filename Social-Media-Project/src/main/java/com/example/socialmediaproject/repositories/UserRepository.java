package com.example.socialmediaproject.repositories;

import com.example.socialmediaproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}

package com.example.socialmediaproject.controllers;

import com.example.socialmediaproject.entities.User;
import com.example.socialmediaproject.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {

        return userRepository.save(newUser);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long id, @RequestBody User userToUpdate) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            // this line will be checked for  an update process , may be incorrect
            userToUpdate.setId(user.get().getId());
            return userRepository.save(userToUpdate);
        } else {
            return null;
        }

    }


    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long id) {

        //custom exception throw
        return userRepository.findById(id).orElse(null);

    }

}

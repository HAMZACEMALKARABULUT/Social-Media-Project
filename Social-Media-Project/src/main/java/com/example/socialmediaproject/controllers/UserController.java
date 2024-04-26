package com.example.socialmediaproject.controllers;

import com.example.socialmediaproject.entities.User;

import com.example.socialmediaproject.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {


        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userService.save(newUser);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User userToUpdate) {

        return userService.updateUser(userId, userToUpdate);


    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {

        return userService.deleteById(userId);
    }

    @GetMapping("/{userId}")
    public Optional<User> getUser(@PathVariable Long userId) {

        //custom exception throw
        return userService.findById(userId);


    }
    @PostMapping("/login")
    public User userAuthentication(@RequestBody User user){

        return userService.userAuthentication(user.getUserName(),user.getPassword());
    }


}

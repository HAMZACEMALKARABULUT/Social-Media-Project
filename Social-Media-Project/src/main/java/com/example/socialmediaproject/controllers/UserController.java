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
    public User updateUser(@PathVariable Long userId, @RequestBody User userToUpdate) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            // this line will be checked for  an update process , may be incorrect
           user.get().setUserName(userToUpdate.getUserName());
           user.get().setPassword(userToUpdate.getPassword());
            return userRepository.save(user.get());
        } else {
            return null;
        }

    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){

       userRepository.deleteById(userId);
    }


    @GetMapping("/{userId}")
    public Optional<User> getUser(@PathVariable Long userId) {

        //custom exception throw
         Optional<User> user=userRepository.findById(userId);

         if(user.isPresent()){
             return user;
         }
         else{
        return null;}
    }

}

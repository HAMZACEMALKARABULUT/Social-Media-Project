package com.example.socialmediaproject.services;

import com.example.socialmediaproject.entities.User;
import com.example.socialmediaproject.repositories.UserRepository;
import com.example.socialmediaproject.services.exception.CustomException;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> findById(Long userId) {

        return userRepository.findById(userId);
    }

    public User save(User user) {

        Argon2PasswordEncoder arg2SpringSecurity = new Argon2PasswordEncoder(16, 32, 1, 60000, 10);
        String encryptedPassword = arg2SpringSecurity.encode(user.getPassword());
        user.setPassword(encryptedPassword);


        return userRepository.save(user);
    }

    public User userAuthentication(String userName, String password) {
        Optional<User> user = userRepository.findByUserName(userName);


        if (user.isPresent()) {
            Argon2PasswordEncoder arg2SpringSecurity = new Argon2PasswordEncoder(16, 32, 1, 60000, 10);

            if (arg2SpringSecurity.matches(password, user.get().getPassword())) {
                return user.get();
            } else throw (new CustomException("Kullanıcı Adı veya Şifre yanlış"));


        } else throw (new CustomException("Kullanıcı Adı veya Şifre yanlış"));
    }

    public String deleteById(Long userId) {

        if (findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return "Başarıyla silindi";
        } else {
            return "Başarısız istek ";
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User updateUser(Long userId, User userToUpdate) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            // this line will be checked for  an update process , may be incorrect
            user.get().setUserName(userToUpdate.getUserName());
            user.get().setPassword(userToUpdate.getPassword());
            return save(user.get());
        } else {
            return null;
        }


    }
}

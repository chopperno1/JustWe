package com.JustWe.controller;

import com.JustWe.UserRepository;
import com.JustWe.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/jpa/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.isPresent() ? optional.get(): null;
    }

    @GetMapping("/user/jpa")
    public User insertUser(User user) {
        User save = userRepository.save(user);
        return save;
    }



}

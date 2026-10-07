package com.example.weather_backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather_backend.Entity.User;
import com.example.weather_backend.Repository.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserRepository ur;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return ur.save(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return ur.findAll();
    }
}
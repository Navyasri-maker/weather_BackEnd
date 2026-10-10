package com.example.weather.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather.Entity.User;
import com.example.weather.Repository.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserRepository ur;

    @PostMapping("/add")
    @RequestMapping("/user")
    public User addUser(@RequestBody User user) {
        return ur.save(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return ur.findAll();
    }
}
package com.example.weather_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather_backend.Service.TimeService;

@RestController
@RequestMapping("/time")
@CrossOrigin(origins = "*")
public class TimeController {

    @Autowired
    TimeService ts;

    @GetMapping
    public String getTime() {
        return ts.getTime();
    }
}
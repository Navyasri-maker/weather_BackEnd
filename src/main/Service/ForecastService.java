package com.example.weather.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather.Service.ForecastService;

@RestController
@RequestMapping("/forecast")
@CrossOrigin(origins = "*")
public class ForecastController {

    @Autowired
    ForecastService fs;

    @GetMapping("/{city}")
    public String getForecast(@PathVariable String city) {
        return fs.getForecast(city);
    }
}
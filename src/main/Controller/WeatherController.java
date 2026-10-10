package com.example.weather.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.externalapi.service.WeatherService;


@RestController 
@RequestMapping ("/weather")
@CrossOrigin (origins = "*")
public class WeatherController 
{
    @Autowired 
    WeatherService ws;

//     http://localhost:8080/weather/getWeather?city=manali
    @GetMapping("/getWeather")
    public String getWeather(@RequestParam String city)
    {
        //return "hey iam weather";
        return this.ws.getWeatherService(city);
    }
} 

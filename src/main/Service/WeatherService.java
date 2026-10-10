package com.example.weather.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service 
public class WeatherService
{
    RestTemplate res = new RestTemplate();
    String API_KEY = "68ec710d4d493f7cefc6d04c5075a687";
    
    public String getWeatherService(String city)
    {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + this.API_KEY+"&units=metric";
        ResponseEntity<Map> response =this.res.getForEntity(url, Map.class);
        System.out.println(response);
        if(response.getStatusCode().is2xxSuccessful())
        {
            Map body= response.getBody();
            Map main= (Map)body.get("main");
            Map weather= ((List<Map>) body.get("weather")).get(0);
            double temp= (double)main.get("temp");
            String descr= (String)weather.get("description");
            return "Current weatheer in " +city+ "is " +temp+" "+descr; 
        }

        return "hey " +city+ " iam weather Service ";
    }
}

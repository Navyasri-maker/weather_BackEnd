package com.example.weather_backend.Service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TimeService {

    public String getTime() {
        return LocalDateTime.now().toString();
    }
}
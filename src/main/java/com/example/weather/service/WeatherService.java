package com.example.weather.service;

import java.net.URI;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey;

    public WeatherService(@Value("${weather.api.key}") String apiKey) {
        this.apiKey = apiKey;
    }

    public Map<String, Object> getWeather(String city) {
        if (apiKey.isBlank()) {
            throw new IllegalStateException("Set the WEATHER_API_KEY environment variable.");
        }

        URI uri = UriComponentsBuilder
                .fromUriString("https://api.openweathermap.org/data/2.5/weather")
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .build()
                .encode()
                .toUri();

        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>() {
                });

        return Objects.requireNonNull(response.getBody(), "OpenWeather returned an empty response.");
    }
}

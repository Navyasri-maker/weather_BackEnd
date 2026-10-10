
package com.example.weather.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TimeService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${timezone.api.key}")
    private String apiKey;

    public String getTimeService(String cname) {

        String url = "https://api.timezonedb.com/v2.1/get-time-zone"
                + "?key=" + apiKey
                + "&format=json"
                + "&by=zone"
                + "&zone=" + cname;

        try {
            ResponseEntity<Map> response =
                    restTemplate.getForEntity(url, Map.class);

            Map body = response.getBody();

            if (response.getStatusCode().is2xxSuccessful()
                    && body != null) {
                return body.toString();
            }

            return "API Error: " + response.getStatusCode();

        } catch (Exception e) {
            return "Error fetching time: " + e.getMessage();
        }
    }
}

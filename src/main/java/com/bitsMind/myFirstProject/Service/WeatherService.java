package com.bitsMind.myFirstProject.Service;

import com.bitsMind.myFirstProject.Api.Response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String apiKey="dab839bd068c2d844dc9a71db079baef";
    private static final String API="https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";
    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
        String finalAPI = API.replace("CITY", city).replace("API_KEY", apiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }
}

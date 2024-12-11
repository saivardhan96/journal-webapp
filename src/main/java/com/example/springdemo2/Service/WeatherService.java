package com.example.springdemo2.Service;

import com.example.springdemo2.api.response.WeatherResponse;
import com.example.springdemo2.cache.AppCache;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class WeatherService {

    private final AppCache appCache;

    public WeatherService(AppCache appCache) {
        this.appCache = appCache;
    }

    public WeatherResponse getWeatherResp(){
        RestClient restClient = RestClient.create();
        WeatherResponse weatherResponse = restClient.get()
                .uri(appCache.cache.get(AppCache.Keys.WEATHER_API.toString()))
                .retrieve()
                .body(WeatherResponse.class);
        return weatherResponse;
    }
}

package com.example.springdemo2.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WeatherResponse {
    private Main main;
    @Getter
    @Setter
    public class Main {
        private double temp;
        @JsonProperty("feels_like")
        private double feelsLike;
    }

}
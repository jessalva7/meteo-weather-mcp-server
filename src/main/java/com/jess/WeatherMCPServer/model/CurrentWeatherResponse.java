package com.jess.WeatherMCPServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CurrentWeatherResponse(String time, int interval,
        @JsonProperty("temperature_2m") double temperature2m,
        @JsonProperty("wind_speed_10m") double windSpeed10m) {

}

package com.jess.WeatherMCPServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Units for current weather data
 */
public class CurrentUnits {
    private String time;
    private String interval;
    
    @JsonProperty("temperature_2m")
    private String temperature2m;
    
    @JsonProperty("wind_speed_10m")
    private String windSpeed10m;

    // Constructors
    public CurrentUnits() {}

    // Getters and Setters
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getInterval() { return interval; }
    public void setInterval(String interval) { this.interval = interval; }

    public String getTemperature2m() { return temperature2m; }
    public void setTemperature2m(String temperature2m) { this.temperature2m = temperature2m; }

    public String getWindSpeed10m() { return windSpeed10m; }
    public void setWindSpeed10m(String windSpeed10m) { this.windSpeed10m = windSpeed10m; }
}
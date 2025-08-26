package com.jess.WeatherMCPServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Hourly weather data arrays
 */
public class Hourly {
    private List<String> time;
    
    @JsonProperty("temperature_2m")
    private List<Double> temperature2m;
    
    @JsonProperty("relative_humidity_2m")
    private List<Integer> relativeHumidity2m;
    
    @JsonProperty("wind_speed_10m")
    private List<Double> windSpeed10m;

    // Constructors
    public Hourly() {}

    // Getters and Setters
    public List<String> getTime() { return time; }
    public void setTime(List<String> time) { this.time = time; }

    public List<Double> getTemperature2m() { return temperature2m; }
    public void setTemperature2m(List<Double> temperature2m) { this.temperature2m = temperature2m; }

    public List<Integer> getRelativeHumidity2m() { return relativeHumidity2m; }
    public void setRelativeHumidity2m(List<Integer> relativeHumidity2m) { this.relativeHumidity2m = relativeHumidity2m; }

    public List<Double> getWindSpeed10m() { return windSpeed10m; }
    public void setWindSpeed10m(List<Double> windSpeed10m) { this.windSpeed10m = windSpeed10m; }
}
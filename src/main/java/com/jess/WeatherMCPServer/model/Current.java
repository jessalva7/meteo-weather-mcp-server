package com.jess.WeatherMCPServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Current weather data
 */
public class Current {
    private String time;
    private int interval;
    
    @JsonProperty("temperature_2m")
    private double temperature2m;
    
    @JsonProperty("wind_speed_10m")
    private double windSpeed10m;

    // Constructors
    public Current() {}

    // Getters and Setters
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public int getInterval() { return interval; }
    public void setInterval(int interval) { this.interval = interval; }

    public double getTemperature2m() { return temperature2m; }
    public void setTemperature2m(double temperature2m) { this.temperature2m = temperature2m; }

    public double getWindSpeed10m() { return windSpeed10m; }
    public void setWindSpeed10m(double windSpeed10m) { this.windSpeed10m = windSpeed10m; }
}
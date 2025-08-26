package com.jess.WeatherMCPServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Units for hourly weather data
 */
public class HourlyUnits {
    private String time;
    
    @JsonProperty("temperature_2m")
    private String temperature2m;
    
    @JsonProperty("relative_humidity_2m")
    private String relativeHumidity2m;
    
    @JsonProperty("wind_speed_10m")
    private String windSpeed10m;

    // Constructors
    public HourlyUnits() {}

    // Getters and Setters
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getTemperature2m() { return temperature2m; }
    public void setTemperature2m(String temperature2m) { this.temperature2m = temperature2m; }

    public String getRelativeHumidity2m() { return relativeHumidity2m; }
    public void setRelativeHumidity2m(String relativeHumidity2m) { this.relativeHumidity2m = relativeHumidity2m; }

    public String getWindSpeed10m() { return windSpeed10m; }
    public void setWindSpeed10m(String windSpeed10m) { this.windSpeed10m = windSpeed10m; }
}
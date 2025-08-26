package com.jess.WeatherMCPServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Current weather conditions data model.
 * 
 * Represents real-time weather measurements including temperature and wind speed
 * at the time of the API request. This data is part of the comprehensive weather
 * response from the Open-Meteo API.
 * 
 * @author Jess
 * @version 1.0
 */
public class Current {
    /** Timestamp of the current weather observation */
    private String time;
    
    /** Measurement interval in seconds */
    private int interval;
    
    /** Current temperature at 2 meters height */
    @JsonProperty("temperature_2m")
    private double temperature2m;
    
    /** Current wind speed at 10 meters height */
    @JsonProperty("wind_speed_10m")
    private double windSpeed10m;

    /**
     * Default constructor for JSON deserialization.
     */
    public Current() {}

    /**
     * Gets the observation timestamp.
     * @return timestamp string in ISO format
     */
    public String getTime() { return time; }
    
    /**
     * Sets the observation timestamp.
     * @param time timestamp string in ISO format
     */
    public void setTime(String time) { this.time = time; }

    /**
     * Gets the measurement interval.
     * @return interval in seconds
     */
    public int getInterval() { return interval; }
    
    /**
     * Sets the measurement interval.
     * @param interval interval in seconds
     */
    public void setInterval(int interval) { this.interval = interval; }

    /**
     * Gets the current temperature at 2 meters height.
     * @return temperature in Celsius
     */
    public double getTemperature2m() { return temperature2m; }
    
    /**
     * Sets the current temperature at 2 meters height.
     * @param temperature2m temperature in Celsius
     */
    public void setTemperature2m(double temperature2m) { this.temperature2m = temperature2m; }

    /**
     * Gets the current wind speed at 10 meters height.
     * @return wind speed in km/h
     */
    public double getWindSpeed10m() { return windSpeed10m; }
    
    /**
     * Sets the current wind speed at 10 meters height.
     * @param windSpeed10m wind speed in km/h
     */
    public void setWindSpeed10m(double windSpeed10m) { this.windSpeed10m = windSpeed10m; }
}
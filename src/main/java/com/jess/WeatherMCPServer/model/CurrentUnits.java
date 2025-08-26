package com.jess.WeatherMCPServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Units of measurement for current weather data fields.
 * 
 * Specifies the measurement units used for current weather parameters
 * in the API response, ensuring proper interpretation of numeric values.
 * 
 * @author Jess
 * @version 1.0
 */
public class CurrentUnits {
    /** Unit for time measurements */
    private String time;
    
    /** Unit for interval measurements */
    private String interval;
    
    /** Unit for temperature measurements at 2m height */
    @JsonProperty("temperature_2m")
    private String temperature2m;
    
    /** Unit for wind speed measurements at 10m height */
    @JsonProperty("wind_speed_10m")
    private String windSpeed10m;

    /**
     * Default constructor for JSON deserialization.
     */
    public CurrentUnits() {}

    /**
     * Gets the time unit.
     * @return time unit string
     */
    public String getTime() { return time; }
    
    /**
     * Sets the time unit.
     * @param time time unit string
     */
    public void setTime(String time) { this.time = time; }

    /**
     * Gets the interval unit.
     * @return interval unit string
     */
    public String getInterval() { return interval; }
    
    /**
     * Sets the interval unit.
     * @param interval interval unit string
     */
    public void setInterval(String interval) { this.interval = interval; }

    /**
     * Gets the temperature unit.
     * @return temperature unit string (typically "°C")
     */
    public String getTemperature2m() { return temperature2m; }
    
    /**
     * Sets the temperature unit.
     * @param temperature2m temperature unit string
     */
    public void setTemperature2m(String temperature2m) { this.temperature2m = temperature2m; }

    /**
     * Gets the wind speed unit.
     * @return wind speed unit string (typically "km/h")
     */
    public String getWindSpeed10m() { return windSpeed10m; }
    
    /**
     * Sets the wind speed unit.
     * @param windSpeed10m wind speed unit string
     */
    public void setWindSpeed10m(String windSpeed10m) { this.windSpeed10m = windSpeed10m; }
}
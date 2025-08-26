package com.jess.WeatherMCPServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Units of measurement for hourly weather forecast data fields.
 * 
 * Specifies the measurement units used for hourly weather parameters
 * in the API response, ensuring proper interpretation of forecast values.
 * 
 * @author Jess
 * @version 1.0
 */
public class HourlyUnits {
    /** Unit for time measurements in hourly data */
    private String time;
    
    /** Unit for temperature measurements at 2m height */
    @JsonProperty("temperature_2m")
    private String temperature2m;
    
    /** Unit for relative humidity measurements */
    @JsonProperty("relative_humidity_2m")
    private String relativeHumidity2m;
    
    /** Unit for wind speed measurements at 10m height */
    @JsonProperty("wind_speed_10m")
    private String windSpeed10m;

    /**
     * Default constructor for JSON deserialization.
     */
    public HourlyUnits() {}

    /**
     * Gets the time unit for hourly data.
     * @return time unit string
     */
    public String getTime() { return time; }
    
    /**
     * Sets the time unit for hourly data.
     * @param time time unit string
     */
    public void setTime(String time) { this.time = time; }

    /**
     * Gets the temperature unit for hourly forecasts.
     * @return temperature unit string (typically "°C")
     */
    public String getTemperature2m() { return temperature2m; }
    
    /**
     * Sets the temperature unit for hourly forecasts.
     * @param temperature2m temperature unit string
     */
    public void setTemperature2m(String temperature2m) { this.temperature2m = temperature2m; }

    /**
     * Gets the relative humidity unit.
     * @return humidity unit string (typically "%")
     */
    public String getRelativeHumidity2m() { return relativeHumidity2m; }
    
    /**
     * Sets the relative humidity unit.
     * @param relativeHumidity2m humidity unit string
     */
    public void setRelativeHumidity2m(String relativeHumidity2m) { this.relativeHumidity2m = relativeHumidity2m; }

    /**
     * Gets the wind speed unit for hourly forecasts.
     * @return wind speed unit string (typically "km/h")
     */
    public String getWindSpeed10m() { return windSpeed10m; }
    
    /**
     * Sets the wind speed unit for hourly forecasts.
     * @param windSpeed10m wind speed unit string
     */
    public void setWindSpeed10m(String windSpeed10m) { this.windSpeed10m = windSpeed10m; }
}
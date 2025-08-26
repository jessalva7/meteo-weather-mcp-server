package com.jess.WeatherMCPServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Hourly weather forecast data model.
 * 
 * Contains arrays of weather measurements for each hour in the forecast period,
 * including temperature, humidity, and wind speed predictions. Each array index
 * corresponds to the same time period across all measurement types.
 * 
 * @author Jess
 * @version 1.0
 */
public class Hourly {
    /** Array of timestamps for each hourly forecast point */
    private List<String> time;
    
    /** Array of temperature forecasts at 2m height for each hour */
    @JsonProperty("temperature_2m")
    private List<Double> temperature2m;
    
    /** Array of relative humidity forecasts for each hour */
    @JsonProperty("relative_humidity_2m")
    private List<Integer> relativeHumidity2m;
    
    /** Array of wind speed forecasts at 10m height for each hour */
    @JsonProperty("wind_speed_10m")
    private List<Double> windSpeed10m;

    /**
     * Default constructor for JSON deserialization.
     */
    public Hourly() {}

    /**
     * Gets the array of forecast timestamps.
     * @return list of timestamp strings in ISO format
     */
    public List<String> getTime() { return time; }
    
    /**
     * Sets the array of forecast timestamps.
     * @param time list of timestamp strings
     */
    public void setTime(List<String> time) { this.time = time; }

    /**
     * Gets the array of hourly temperature forecasts.
     * @return list of temperature values in Celsius
     */
    public List<Double> getTemperature2m() { return temperature2m; }
    
    /**
     * Sets the array of hourly temperature forecasts.
     * @param temperature2m list of temperature values
     */
    public void setTemperature2m(List<Double> temperature2m) { this.temperature2m = temperature2m; }

    /**
     * Gets the array of hourly relative humidity forecasts.
     * @return list of humidity percentages (0-100)
     */
    public List<Integer> getRelativeHumidity2m() { return relativeHumidity2m; }
    
    /**
     * Sets the array of hourly relative humidity forecasts.
     * @param relativeHumidity2m list of humidity percentages
     */
    public void setRelativeHumidity2m(List<Integer> relativeHumidity2m) { this.relativeHumidity2m = relativeHumidity2m; }

    /**
     * Gets the array of hourly wind speed forecasts.
     * @return list of wind speed values in km/h
     */
    public List<Double> getWindSpeed10m() { return windSpeed10m; }
    
    /**
     * Sets the array of hourly wind speed forecasts.
     * @param windSpeed10m list of wind speed values
     */
    public void setWindSpeed10m(List<Double> windSpeed10m) { this.windSpeed10m = windSpeed10m; }
}
package com.jess.WeatherMCPServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simplified current weather response record for MCP tool responses.
 * 
 * This record represents a streamlined version of current weather data,
 * containing only the essential information needed for current weather queries.
 * It extracts key metrics from the full weather response for easier consumption.
 * 
 * @param time timestamp of the weather observation
 * @param interval measurement interval in seconds
 * @param temperature2m current temperature at 2 meters height in Celsius
 * @param windSpeed10m current wind speed at 10 meters height in km/h
 * 
 * @author Jess
 * @version 1.0
 */
public record CurrentWeatherResponse(String time, int interval,
        @JsonProperty("temperature_2m") double temperature2m,
        @JsonProperty("wind_speed_10m") double windSpeed10m) {

}

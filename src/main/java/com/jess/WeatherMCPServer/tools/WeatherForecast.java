package com.jess.WeatherMCPServer.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import com.jess.WeatherMCPServer.model.WeatherResponse;
import com.jess.WeatherMCPServer.service.MeteoWeatherFetcher;

import java.io.IOException;

/**
 * MCP tool service for retrieving comprehensive weather forecasts.
 * 
 * This service provides detailed weather forecast data including current conditions
 * and hourly predictions for specified geographic coordinates. The forecast data
 * includes temperature, wind speed, humidity, and other meteorological parameters.
 * 
 * @author Jess
 * @version 1.0
 */
@Service
public class WeatherForecast {

    private final MeteoWeatherFetcher weatherService;

    /**
     * Constructs a WeatherForecast tool with the specified weather service.
     * 
     * @param weatherService the weather data fetching service
     */
    public WeatherForecast(MeteoWeatherFetcher weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Retrieves a complete weather forecast for the specified coordinates.
     * 
     * This method returns comprehensive weather data including current conditions
     * and hourly forecasts. The response contains detailed meteorological information
     * such as temperature, wind speed, humidity, and weather conditions over time.
     * 
     * @param latitude the geographic latitude (-90 to 90)
     * @param longitude the geographic longitude (-180 to 180)
     * @return complete weather response with current and hourly forecast data
     * @throws RuntimeException if weather forecast cannot be retrieved due to network or API issues
     */
    @Tool(name = "GetWeatherForecast", description = "Get complete weather forecast including current conditions and hourly data for specified coordinates")
    public WeatherResponse getWeatherForecast(double latitude, double longitude) {
        try {
            return weatherService.getWeatherForecast(latitude, longitude);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed to fetch weather forecast: " + e.getMessage(), e);
        }
    }
}
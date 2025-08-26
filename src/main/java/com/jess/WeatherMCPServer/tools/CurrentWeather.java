package com.jess.WeatherMCPServer.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import com.jess.WeatherMCPServer.model.CurrentWeatherResponse;
import com.jess.WeatherMCPServer.model.WeatherResponse;
import com.jess.WeatherMCPServer.service.MeteoWeatherFetcher;

import java.io.IOException;

/**
 * MCP tool service for retrieving current weather conditions.
 * 
 * This service provides real-time weather data for specified geographic coordinates
 * using the Open-Meteo weather API. It extracts current weather information from
 * the full weather response and returns a simplified current weather object.
 * 
 * @author Jess
 * @version 1.0
 */
@Service
public class CurrentWeather {

    private final MeteoWeatherFetcher weatherService;
    
    /**
     * Constructs a CurrentWeather tool with the specified weather service.
     * 
     * @param weatherService the weather data fetching service
     */
    public CurrentWeather(MeteoWeatherFetcher weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Retrieves current weather conditions for the specified coordinates.
     * 
     * This method fetches comprehensive weather data and extracts only the current
     * weather information including temperature, wind speed, and timing details.
     * 
     * @param latitude the geographic latitude (-90 to 90)
     * @param longitude the geographic longitude (-180 to 180)
     * @return current weather response containing temperature, wind speed, and timing
     * @throws RuntimeException if weather data cannot be retrieved due to network or API issues
     */
    @Tool(
        name = "GetCurrentWeather",
        description = "Get current weather for specified coordinates"
    )
    public CurrentWeatherResponse currentWeather(double latitude, double longitude) {
        try {
            WeatherResponse weatherResponse = weatherService.getWeatherForecast(latitude, longitude);
            
            // Extract current weather data from the full response
            var current = weatherResponse.getCurrent();
            return new CurrentWeatherResponse(
                current.getTime(),
                current.getInterval(),
                current.getTemperature2m(),
                current.getWindSpeed10m()
            );
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed to fetch weather data: " + e.getMessage(), e);
        }
    }
}

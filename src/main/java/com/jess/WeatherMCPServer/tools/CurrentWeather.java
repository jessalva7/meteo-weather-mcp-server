package com.jess.WeatherMCPServer.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import com.jess.WeatherMCPServer.model.CurrentWeatherResponse;
import com.jess.WeatherMCPServer.model.WeatherResponse;
import com.jess.WeatherMCPServer.service.MeteoWeatherFetcher;

import java.io.IOException;

@Service
public class CurrentWeather {

    private final MeteoWeatherFetcher weatherService;
    
    public CurrentWeather(MeteoWeatherFetcher weatherService) {
        this.weatherService = weatherService;
    }

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

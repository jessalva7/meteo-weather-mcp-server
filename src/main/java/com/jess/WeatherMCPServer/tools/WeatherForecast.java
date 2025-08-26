package com.jess.WeatherMCPServer.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import com.jess.WeatherMCPServer.model.WeatherResponse;
import com.jess.WeatherMCPServer.service.MeteoWeatherFetcher;

import java.io.IOException;

@Service
public class WeatherForecast {

    private final MeteoWeatherFetcher weatherService;

    public WeatherForecast(MeteoWeatherFetcher weatherService) {
        this.weatherService = weatherService;
    }

    @Tool(name = "GetWeatherForecast", description = "Get complete weather forecast including current conditions and hourly data for specified coordinates")
    public WeatherResponse getWeatherForecast(double latitude, double longitude) {
        try {
            return weatherService.getWeatherForecast(latitude, longitude);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed to fetch weather forecast: " + e.getMessage(), e);
        }
    }
}
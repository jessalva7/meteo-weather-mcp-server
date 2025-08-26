package com.jess.WeatherMCPServer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jess.WeatherMCPServer.model.WeatherResponse;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Service component for fetching weather data from the Open-Meteo API.
 * 
 * This service handles HTTP communication with the Open-Meteo weather API,
 * providing methods to retrieve current weather conditions and hourly forecasts
 * for specified geographic coordinates. It includes proper error handling and
 * timeout configuration for reliable weather data retrieval.
 * 
 * @author Jess
 * @version 1.0
 */
@Component
public class MeteoWeatherFetcher {
    
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private static final String BASE_URL = "https://api.open-meteo.com/v1/forecast";
    
    /**
     * Constructs a MeteoWeatherFetcher with configured HTTP client and JSON mapper.
     * 
     * Initializes the HTTP client with a 10-second connection timeout and
     * sets up the ObjectMapper for JSON deserialization of API responses.
     */
    public MeteoWeatherFetcher() {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        this.objectMapper = new ObjectMapper();
    }
    
    /**
     * Fetches comprehensive weather data for the specified coordinates.
     * 
     * Makes an HTTP GET request to the Open-Meteo API to retrieve current weather
     * conditions and hourly forecast data including temperature, humidity, and wind speed.
     * The API response is parsed into a structured WeatherResponse object.
     * 
     * @param latitude the geographic latitude (-90 to 90)
     * @param longitude the geographic longitude (-180 to 180)
     * @return WeatherResponse containing current and hourly weather data
     * @throws IOException if the API call fails due to network issues or invalid response
     * @throws InterruptedException if the HTTP request is interrupted
     */
    public WeatherResponse getWeatherForecast(double latitude, double longitude) 
            throws IOException, InterruptedException {
        
        String url = String.format("%s?latitude=%.2f&longitude=%.2f&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m",
                BASE_URL, latitude, longitude);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(30))
                .GET()
                .build();
        
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() != 200) {
            throw new IOException("API call failed with status code: " + response.statusCode() + 
                    ", body: " + response.body());
        }
        
        return objectMapper.readValue(response.body(), WeatherResponse.class);
    }
}
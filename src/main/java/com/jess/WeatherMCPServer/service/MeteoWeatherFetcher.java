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

@Component
public class MeteoWeatherFetcher {
    
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private static final String BASE_URL = "https://api.open-meteo.com/v1/forecast";
    
    public MeteoWeatherFetcher() {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        this.objectMapper = new ObjectMapper();
    }
    
    /**
     * Fetches weather data for the specified coordinates
     * @param latitude Latitude coordinate
     * @param longitude Longitude coordinate
     * @return WeatherResponse containing current and hourly weather data
     * @throws IOException if the API call fails
     * @throws InterruptedException if the request is interrupted
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
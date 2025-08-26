package com.jess.WeatherMCPServer;

import java.util.List;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jess.WeatherMCPServer.tools.CurrentWeather;
import com.jess.WeatherMCPServer.tools.WeatherForecast;

/**
 * Main Spring Boot application class for the Weather MCP Server.
 * 
 * This application provides a Model Context Protocol (MCP) server that exposes
 * weather-related tools for AI applications. The server offers current weather
 * conditions and weather forecasting capabilities through MCP tool callbacks.
 * 
 * @author Jess
 * @version 1.0
 */
@SpringBootApplication
public class WeatherMcpServerApplication {

	/**
	 * Main entry point for the Weather MCP Server application.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(WeatherMcpServerApplication.class, args);
	}

	/**
	 * Configures and provides the list of MCP tool callbacks available to clients.
	 * 
	 * @param wCurrentWeather the current weather tool implementation
	 * @param weatherForecast the weather forecast tool implementation
	 * @return a list of tool callbacks for MCP client integration
	 */
	@Bean
	public List<ToolCallback> tools(CurrentWeather wCurrentWeather,
		WeatherForecast weatherForecast
	) {
		return List.of(
			ToolCallbacks.from(wCurrentWeather, weatherForecast)
		);
	}

}

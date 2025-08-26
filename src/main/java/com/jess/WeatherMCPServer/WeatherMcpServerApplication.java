package com.jess.WeatherMCPServer;

import java.util.List;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jess.WeatherMCPServer.tools.CurrentWeather;
import com.jess.WeatherMCPServer.tools.WeatherForecast;

@SpringBootApplication
public class WeatherMcpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherMcpServerApplication.class, args);
	}

	@Bean
	public List<ToolCallback> tools(CurrentWeather wCurrentWeather,
		WeatherForecast weatherForecast
	) {
		return List.of(
			ToolCallbacks.from(wCurrentWeather, weatherForecast)
		);
	}

}

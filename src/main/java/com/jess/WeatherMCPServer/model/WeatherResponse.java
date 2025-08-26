package com.jess.WeatherMCPServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Main weather response model containing comprehensive weather data from Open-Meteo API.
 * 
 * This class represents the complete response structure from the Open-Meteo weather API,
 * including geographic information, current weather conditions, and hourly forecasts.
 * It serves as the primary data transfer object for weather information in the application.
 * 
 * @author Jess
 * @version 1.0
 */
public class WeatherResponse {
    /** Geographic latitude of the weather location */
    private double latitude;
    
    /** Geographic longitude of the weather location */
    private double longitude;
    
    /** API response generation time in milliseconds */
    @JsonProperty("generationtime_ms")
    private double generationtimeMs;
    
    /** UTC offset in seconds for the location's timezone */
    @JsonProperty("utc_offset_seconds")
    private int utcOffsetSeconds;
    
    /** Timezone identifier for the location */
    private String timezone;
    
    /** Abbreviated timezone name */
    @JsonProperty("timezone_abbreviation")
    private String timezoneAbbreviation;
    
    /** Elevation above sea level in meters */
    private double elevation;
    
    /** Units of measurement for current weather data */
    @JsonProperty("current_units")
    private CurrentUnits currentUnits;
    
    /** Current weather conditions */
    private Current current;
    
    /** Units of measurement for hourly weather data */
    @JsonProperty("hourly_units")
    private HourlyUnits hourlyUnits;
    
    /** Hourly weather forecast data */
    private Hourly hourly;

    /**
     * Default constructor for JSON deserialization.
     */
    public WeatherResponse() {}

    /**
     * Gets the geographic latitude.
     * @return latitude coordinate (-90 to 90)
     */
    public double getLatitude() { return latitude; }
    
    /**
     * Sets the geographic latitude.
     * @param latitude latitude coordinate (-90 to 90)
     */
    public void setLatitude(double latitude) { this.latitude = latitude; }

    /**
     * Gets the geographic longitude.
     * @return longitude coordinate (-180 to 180)
     */
    public double getLongitude() { return longitude; }
    
    /**
     * Sets the geographic longitude.
     * @param longitude longitude coordinate (-180 to 180)
     */
    public void setLongitude(double longitude) { this.longitude = longitude; }

    /**
     * Gets the API response generation time.
     * @return generation time in milliseconds
     */
    public double getGenerationtimeMs() { return generationtimeMs; }
    
    /**
     * Sets the API response generation time.
     * @param generationtimeMs generation time in milliseconds
     */
    public void setGenerationtimeMs(double generationtimeMs) { this.generationtimeMs = generationtimeMs; }

    /**
     * Gets the UTC offset for the location's timezone.
     * @return UTC offset in seconds
     */
    public int getUtcOffsetSeconds() { return utcOffsetSeconds; }
    
    /**
     * Sets the UTC offset for the location's timezone.
     * @param utcOffsetSeconds UTC offset in seconds
     */
    public void setUtcOffsetSeconds(int utcOffsetSeconds) { this.utcOffsetSeconds = utcOffsetSeconds; }

    /**
     * Gets the timezone identifier.
     * @return timezone string (e.g., "America/New_York")
     */
    public String getTimezone() { return timezone; }
    
    /**
     * Sets the timezone identifier.
     * @param timezone timezone string
     */
    public void setTimezone(String timezone) { this.timezone = timezone; }

    /**
     * Gets the abbreviated timezone name.
     * @return timezone abbreviation (e.g., "EST", "PST")
     */
    public String getTimezoneAbbreviation() { return timezoneAbbreviation; }
    
    /**
     * Sets the abbreviated timezone name.
     * @param timezoneAbbreviation timezone abbreviation
     */
    public void setTimezoneAbbreviation(String timezoneAbbreviation) { this.timezoneAbbreviation = timezoneAbbreviation; }

    /**
     * Gets the elevation above sea level.
     * @return elevation in meters
     */
    public double getElevation() { return elevation; }
    
    /**
     * Sets the elevation above sea level.
     * @param elevation elevation in meters
     */
    public void setElevation(double elevation) { this.elevation = elevation; }

    /**
     * Gets the units for current weather measurements.
     * @return current weather units object
     */
    public CurrentUnits getCurrentUnits() { return currentUnits; }
    
    /**
     * Sets the units for current weather measurements.
     * @param currentUnits current weather units object
     */
    public void setCurrentUnits(CurrentUnits currentUnits) { this.currentUnits = currentUnits; }

    /**
     * Gets the current weather conditions.
     * @return current weather data object
     */
    public Current getCurrent() { return current; }
    
    /**
     * Sets the current weather conditions.
     * @param current current weather data object
     */
    public void setCurrent(Current current) { this.current = current; }

    /**
     * Gets the units for hourly weather measurements.
     * @return hourly weather units object
     */
    public HourlyUnits getHourlyUnits() { return hourlyUnits; }
    
    /**
     * Sets the units for hourly weather measurements.
     * @param hourlyUnits hourly weather units object
     */
    public void setHourlyUnits(HourlyUnits hourlyUnits) { this.hourlyUnits = hourlyUnits; }

    /**
     * Gets the hourly weather forecast data.
     * @return hourly weather forecast object
     */
    public Hourly getHourly() { return hourly; }
    
    /**
     * Sets the hourly weather forecast data.
     * @param hourly hourly weather forecast object
     */
    public void setHourly(Hourly hourly) { this.hourly = hourly; }
}
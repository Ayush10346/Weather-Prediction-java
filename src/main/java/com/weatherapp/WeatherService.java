package com.weatherapp;

import com.google.gson.Gson;
import com.weatherapp.model.WeatherResponse;
import java.io.IOException;

public class WeatherService {
    private final WeatherApiClient client;
    private final Gson gson;

    public WeatherService() {
        this.client = new WeatherApiClient();
        this.gson = new Gson();
    }

    public WeatherResponse getWeatherForCity(String city) {
        try {
            String jsonResponse = client.getWeatherData(city);
            return gson.fromJson(jsonResponse, WeatherResponse.class);
        } catch (IOException | InterruptedException e) {
            System.err.println("Failed to fetch weather data: " + e.getMessage());
            return null;
        }
    }
}

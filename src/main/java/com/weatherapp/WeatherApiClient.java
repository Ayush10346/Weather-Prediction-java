package com.weatherapp;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class WeatherApiClient {
    private final HttpClient httpClient;

    public WeatherApiClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String getWeatherData(String city) throws IOException, InterruptedException {
        String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String urlString = String.format("%s?q=%s&appid=%s&units=metric", 
                Config.BASE_URL, encodedCity, Config.getApiKey());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Error: Received HTTP " + response.statusCode() + " from API: " + response.body());
        }

        return response.body();
    }
}

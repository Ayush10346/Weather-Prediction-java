package com.weatherapp;

public class Config {
    // SECURITY: Read API key from environment variable to avoid committing it to
    // GitHub
    public static final String API_KEY = System.getenv("OPENWEATHER_API_KEY");
    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public static String getApiKey() {
        if (API_KEY == null || API_KEY.isEmpty()) {
            System.err.println("Error: OPENWEATHER_API_KEY environment variable is not set.");
            System.exit(1);
        }
        return API_KEY;
    }
}

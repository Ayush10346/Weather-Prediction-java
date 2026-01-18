package com.weatherapp;

import com.weatherapp.model.WeatherResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Java Weather App!");
        System.out.println("Type 'exit' to quit.");

        Scanner scanner = new Scanner(System.in);
        WeatherService service = new WeatherService();

        while (true) {
            System.out.print("\nEnter City Name: ");
            String city = scanner.nextLine().trim();

            if (city.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            if (city.isEmpty()) {
                continue;
            }

            System.out.println("Fetching weather for " + city + "...");
            WeatherResponse weather = service.getWeatherForCity(city);

            if (weather != null) {
                printWeather(weather);
            } else {
                System.out.println("Could not retrieve weather data. Please check the city name or API Key.");
            }
        }
        scanner.close();
    }

    private static void printWeather(WeatherResponse w) {
        System.out.println("------------------------------------------------");
        System.out.printf("Weather in %s%n", w.getName());
        if (w.getMain() != null) {
             System.out.printf("Temperature: %.2f °C%n", w.getMain().getTemp());
             System.out.printf("Humidity: %d%%%n", w.getMain().getHumidity());
        }
        if (w.getWeather() != null && !w.getWeather().isEmpty()) {
            System.out.printf("Condition: %s (%s)%n", 
                    w.getWeather().get(0).getMain(), 
                    w.getWeather().get(0).getDescription());
        }
        if (w.getWind() != null) {
            System.out.printf("Wind Speed: %.2f m/s%n", w.getWind().getSpeed());
        }
        System.out.println("------------------------------------------------");
    }
}

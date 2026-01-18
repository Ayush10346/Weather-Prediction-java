# Java Weather Prediction App

A console-based weather application that fetches real-time weather data using the OpenWeatherMap API.

## Features
- Real-time weather updates by city name.
- Displays Temperature, Humidity, Wind Speed, and Conditions.
- Built with Java (No heavy framework dependencies, uses Gson for JSON parsing).

## Prerequisites
- Java JDK 11 or higher.
- An OpenWeatherMap API Key.

## Setup & Running

1.  **Clone the repository** (if you haven't already).
2.  **Compile the project**:

    First, create the `bin` directory (if it doesn't exist):
    ```powershell
    mkdir bin
    ```

    Then compile:
    ```powershell
    javac -cp "lib/gson-2.10.1.jar" -d bin -sourcepath src/main/java src/main/java/com/weatherapp/Main.java
    ```
3.  **Set your API Key**:
    You need to set the `OPENWEATHER_API_KEY` environment variable.
    **PowerShell**:
    ```powershell
    $env:OPENWEATHER_API_KEY="your_actual_api_key_here"
    ```
    **Command Prompt**:
    ```cmd
    set OPENWEATHER_API_KEY=your_actual_api_key_here
    ```
4.  **Run the application**:
    ```powershell
    java -cp "bin;lib/gson-2.10.1.jar" com.weatherapp.Main
    ```

## Project Structure
- `src/main/java`: Source code.
- `lib/`: Dependencies (Gson).
- `bin/`: Compiled bytecode (ignored by git).

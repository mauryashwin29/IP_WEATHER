package com.ipweather;

import com.ipweather.controller.WeatherController;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) {

        try {

            // Create HTTP server on port 8080
            HttpServer server =
                    HttpServer.create(
                            new InetSocketAddress(8080),
                            0
                    );

            // Create weather API endpoint
            server.createContext(
                    "/api/weather",
                    new WeatherController()
            );

            // Start server
            server.start();

            System.out.println("=================================");
            System.out.println("       IP WEATHER BACKEND");
            System.out.println("=================================");
            System.out.println("Server started successfully!");
            System.out.println(
                    "API: http://localhost:8080/api/weather"
            );
            System.out.println("=================================");

        } catch (Exception e) {

            System.out.println(
                    "Server error: " + e.getMessage()
            );
        }
    }
}
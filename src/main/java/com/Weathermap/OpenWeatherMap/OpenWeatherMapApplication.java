package com.Weathermap.OpenWeatherMap;

import org.springframework.boot.SpringApplication;
import java.util.Scanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenWeatherMapApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenWeatherMapApplication.class, args);
		
        WeatherService weatherService = new WeatherService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer.
            
           //In this both date and time are taken as input to give more accurate answer.
            switch (option) {
            case 1:
                System.out.print("Enter the date and time (yyyy-MM-dd HH:mm:ss): ");
                String dateTime = scanner.nextLine();
                WeatherDataItem weatherDataItem = weatherService.getWeatherDataForDateTime(dateTime);
                if (weatherDataItem != null) {
                    double temperature = weatherDataItem.getMain().getTemp();
                    System.out.println("Temperature on " + dateTime + ": " + temperature + "°K");
                } else {
                    System.out.println("Weather data not found for the given date and time.");
                }
                break;
            case 2:
                System.out.print("Enter the date and time (yyyy-MM-dd HH:mm:ss): ");
                dateTime = scanner.nextLine();
                weatherDataItem = weatherService.getWeatherDataForDateTime(dateTime);
                if (weatherDataItem != null) {
                    double windSpeed = weatherDataItem.getWind().getSpeed();
                    System.out.println("Wind Speed on " + dateTime + ": " + windSpeed + " m/s");
                } else {
                    System.out.println("Weather data not found for the given date and time.");
                }
                break;
            case 3:
                System.out.print("Enter the date and time (yyyy-MM-dd HH:mm:ss): ");
                dateTime = scanner.nextLine();
                weatherDataItem = weatherService.getWeatherDataForDateTime(dateTime);
                if (weatherDataItem != null) {
                    double pressure = weatherDataItem.getMain().getPressure();
                    System.out.println("Pressure on " + dateTime + ": " + pressure + " hPa");
                } else {
                    System.out.println("Weather data not found for the given date and time.");
                }
                break;
            case 0:
                System.out.println("Exiting the program. Goodbye!");
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

//  Use this only when date is given as input.

//            switch (option) {
//                case 1:
//                    System.out.print("Enter the date (yyyy-MM-dd): ");
//                    String date = scanner.nextLine();
//                    double temperature = weatherService.getTemperatureForDate(date);
//                    if (!Double.isNaN(temperature)) {
//                        System.out.println("Temperature on " + date + ": " + temperature + "°K");
//                    } else {
//                        System.out.println("Temperature not found for the given date.");
//                    }
//                    break;
//                case 2:
//                    System.out.print("Enter the date (yyyy-MM-dd): ");
//                    date = scanner.nextLine();
//                    double windSpeed = weatherService.getWindSpeedForDate(date);
//                    if (!Double.isNaN(windSpeed)) {
//                        System.out.println("Wind Speed on " + date + ": " + windSpeed + " m/s");
//                    } else {
//                        System.out.println("Wind speed not found for the given date.");
//                    }
//                    break;
//                case 3:
//                    System.out.print("Enter the date (yyyy-MM-dd): ");
//                    date = scanner.nextLine();
//                    double pressure = weatherService.getPressureForDate(date);
//                    if (!Double.isNaN(pressure)) {
//                        System.out.println("Pressure on " + date + ": " + pressure + " hPa");
//                    } else {
//                        System.out.println("Pressure not found for the given date.");
//                    }
//                    break;
//                case 0:
//                    System.out.println("Exiting the program. Goodbye!");
//                    return;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
//        }
//    }

    private static void printMenu() {
        System.out.println("1. Get weather");
        System.out.println("2. Get Wind Speed");
        System.out.println("3. Get Pressure");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
}

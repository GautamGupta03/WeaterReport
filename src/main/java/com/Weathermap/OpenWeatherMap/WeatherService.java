package com.Weathermap.OpenWeatherMap;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String API_BASE_URL = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22";

    public WeatherData getWeatherData() {
        RestTemplate restTemplate = new RestTemplate();
        WeatherData weatherData = restTemplate.getForObject(API_BASE_URL, WeatherData.class);
        return weatherData;
    }

    
 // Extract weather information for the given date and time
    public WeatherDataItem getWeatherDataForDateTime(String dateTime) {
        WeatherData weatherData = getWeatherData();
        for (WeatherDataItem item : weatherData.getList()) {
            if (item.getDt_txt().equals(dateTime)) {
                return item;
            }
        }
        return null; // Weather data not found for the given date and time
    }

 // Use this commented code only when date is given as an input to fetch out answer.   

//    // Extract temperature for the given date
//    public double getTemperatureForDate(String date) {
//        WeatherData weatherData = getWeatherData();
//        for (WeatherDataItem item : weatherData.getList()) {
//            if (item.getDt_txt().startsWith(date)) {
//                return item.getMain().getTemp();
//            }
//        }
//        return Double.NaN; // Temperature not found for the given date
//    }
//
//    // Extract wind speed for the given date
//    public double getWindSpeedForDate(String date) {
//        WeatherData weatherData = getWeatherData();
//        for (WeatherDataItem item : weatherData.getList()) {
//            if (item.getDt_txt().startsWith(date)) {
//                return item.getWind().getSpeed();
//            }
//        }
//        return Double.NaN; // Wind speed not found for the given date
//    }
//
//    // Extract pressure for the given date
//    public double getPressureForDate(String date) {
//        WeatherData weatherData = getWeatherData();
//        for (WeatherDataItem item : weatherData.getList()) {
//            if (item.getDt_txt().startsWith(date)) {
//                return item.getMain().getPressure();
//            }
//        }
//        return Double.NaN; // Pressure not found for the given date
//    }
}

package com.rafalstefanski.springweatherapp.weatherApp.service;

import com.rafalstefanski.springweatherapp.weatherApp.model.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private int woeid = 523920;
    //523920 warszawa
    //493417 gdańsk - brak
    //514048 poznan - brak

    public void setWoeid(int woeid) {
        this.woeid = woeid;
    }

    public int getWoeid() {
        return woeid;
    }

    public Weather getWeatherForecast() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.metaweather.com/api/location/" + woeid;

        Weather weather = restTemplate.getForObject(url, Weather.class);

//        return restTemplate
//                .getForObject("https://www.metaweather.com/api/location/"+ woeid,
////                .getForObject("https://www.metaweather.com/api/location/2487956",
//                        Weather.class);

        return weather;
    }

//    private String cityName;
//
//    public String getCityName() {
//        return cityName;
//    }
//
//    public void setCityName(String cityName) {
//        this.cityName = cityName;
//    }
//
//    public Location getLocation() {
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "/api/location/search/?query=" + cityName;
//
//        Location location = restTemplate.getForObject(url, Location.class);
//
//        return location;
//    }

}

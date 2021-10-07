package com.rafalstefanski.springweatherapp.weatherApp.service;

import com.rafalstefanski.springweatherapp.weatherApp.model.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private int woeid = 523920;
    //523920 warszawa
    //493417 gdańsk - brak prognozy
    //514048 poznań - brak prognozy

    public void setWoeid(int woeid) {
        this.woeid = woeid;
    }

    public int getWoeid() {
        return woeid;
    }

    public Weather getWeatherForecast() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.metaweather.com/api/location/" + woeid;

        return restTemplate.getForObject(url, Weather.class);
    }
}

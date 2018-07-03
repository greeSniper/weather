package com.weather.controller;

import com.weather.service.WeatherService;
import com.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 唐哲
 * 2018-02-24 12:37
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {
        return weatherService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName")
    public WeatherResponse getWeatherByCityName(@RequestParam("cityName") String cityName) {
        return weatherService.getDataByCityName(cityName);
    }

}

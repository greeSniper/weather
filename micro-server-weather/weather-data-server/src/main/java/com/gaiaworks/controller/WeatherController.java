package com.gaiaworks.controller;

import com.gaiaworks.service.WeatherDataService;
import com.gaiaworks.vo.WeatherResponse;
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
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName")
    public WeatherResponse getWeatherByCityName(@RequestParam("cityName") String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }

}

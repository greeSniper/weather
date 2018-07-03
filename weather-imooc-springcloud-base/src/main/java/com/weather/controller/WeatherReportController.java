package com.weather.controller;

import com.weather.service.CityService;
import com.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 唐哲
 * 2018-02-26 16:33
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private CityService cityService;
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId,
                                          Model model) throws Exception {
        model.addAttribute("title", "天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityService.getCityList());
        model.addAttribute("report", weatherService.getDataByCityId(cityId).getData());
        return new ModelAndView("weather/report", "reportModel", model);
    }

}

package com.gaiaworks.controller;

import com.gaiaworks.service.CityService;
import com.gaiaworks.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 唐哲
 * 2018-03-01 13:37
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/list")
    public List<City> list() throws Exception {
        List<City> cityList = cityService.getCityList();
        return cityList;
    }

}

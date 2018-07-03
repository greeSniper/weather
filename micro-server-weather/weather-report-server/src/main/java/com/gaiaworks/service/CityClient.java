package com.gaiaworks.service;

import com.gaiaworks.vo.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by 唐哲
 * 2018-03-03 16:59
 */
//@FeignClient("weather-city-service")
public interface CityClient {

    @GetMapping("/city/list")
    List<City> cityList();

}

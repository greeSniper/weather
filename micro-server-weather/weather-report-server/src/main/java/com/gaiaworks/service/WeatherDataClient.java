package com.gaiaworks.service;

import com.gaiaworks.vo.WeatherResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by 唐哲
 * 2018-03-03 17:02
 */
//@FeignClient("weather-data-server")
public interface WeatherDataClient {

    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);

}

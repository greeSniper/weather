package com.gaiaworks.service;

import com.gaiaworks.vo.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by 唐哲
 * 2018-03-03 16:35
 * Feign声明式调用 weather-city-server 服务，
 * 并且是客户端负载均衡的
 * Feign继承了Ribbon
 */
@FeignClient("weather-city-server")
public interface CityClient {

    @GetMapping("/city/list")
    List<City> cityList();

}

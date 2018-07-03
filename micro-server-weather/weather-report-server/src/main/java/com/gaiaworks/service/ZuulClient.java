package com.gaiaworks.service;

import com.gaiaworks.vo.City;
import com.gaiaworks.vo.WeatherResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by 唐哲
 * 2018-03-03 17:18
 * 使用zuul网关调用城市服务和天气数据服务
 * CityClient 和 WeatherDataClient 就没用了
 */
@FeignClient(name="weather-zuul-server", fallback = ZuulClientFallback.class)
public interface ZuulClient {

    /**
     * 通过zuul网关调用城市服务获取城市列表
     */
    @GetMapping("/city-service/city/list")
    List<City> cityList();

    /**
     * 通过zuul网关调用天气数据服务根据城市ID查询天气数据
     */
    @GetMapping("/data-service/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);

}

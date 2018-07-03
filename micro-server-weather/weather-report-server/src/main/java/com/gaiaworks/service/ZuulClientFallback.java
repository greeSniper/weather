package com.gaiaworks.service;

import com.gaiaworks.vo.City;
import com.gaiaworks.vo.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 唐哲
 * 2018-03-03 23:01
 * ZuulClient Fallback
 * 服务熔断回调函数
 */
public class ZuulClientFallback implements ZuulClient {

    @Override
    public List<City> cityList() {
        List<City> cityList = new ArrayList<>();

        City city = new City();
        city.setCityId("101280601");
        city.setCityName("深圳");
        cityList.add(city);

        city = new City();
        city.setCityId("101280301");
        city.setCityName("惠州");
        cityList.add(city);

        return cityList;
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        WeatherResponse weatherResponse = new WeatherResponse();
        return weatherResponse;
    }

}

package com.weather.service;

import com.weather.vo.City;

import java.util.List;

/**
 * Created by 唐哲
 * 2018-02-24 15:59
 */
public interface CityService {

    /* 获取城市列表 **/
    List<City> getCityList() throws Exception;

}

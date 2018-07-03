package com.weather.service;

import com.weather.vo.WeatherResponse;

/**
 * Created by 唐哲
 * 2018-02-24 12:39
 */
public interface WeatherService {

    /* 根据城市ID查询天气数据 **/
    WeatherResponse getDataByCityId(String cityId);

    /* 根据城市名称查询天气数据 **/
    WeatherResponse getDataByCityName(String cityName);

    /* 根据城市ID来同步天气 **/
    void syncDataByCityId(String cityId);

}

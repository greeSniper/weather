package com.gaiaworks.service;

import com.gaiaworks.vo.WeatherResponse;

/**
 * Created by 唐哲
 * 2018-03-01 13:18
 */
public interface WeatherDataService {

    /* 根据城市ID查询天气数据 **/
    WeatherResponse getDataByCityId(String cityId);

    /* 根据城市名称查询天气数据 **/
    WeatherResponse getDataByCityName(String cityName);

}

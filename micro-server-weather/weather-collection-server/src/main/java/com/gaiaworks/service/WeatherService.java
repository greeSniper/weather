package com.gaiaworks.service;

/**
 * Created by 唐哲
 * 2018-03-01 13:00
 */
public interface WeatherService {

    /**
     * 根据城市ID同步天气
     */
    void syncDateByCityId(String cityId);

}

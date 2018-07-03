package com.weather.job;

import com.weather.service.CityService;
import com.weather.service.WeatherService;
import com.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 唐哲
 * 2018-02-24 17:04
 * 天气系统中的定时任务
 */
@Component
@EnableScheduling
@Slf4j
public class WeatherJob {

    @Autowired
    private WeatherService weatherService;
    @Autowired
    private CityService cityService;
    
    /**
     * 同步城市天气数据
     */
    @Scheduled(fixedRate = 2000000)
    public void weatherDataSyncJob() {
        log.info("weather data sync start");
        try {
            //获取城市列表
            List<City> cityList = cityService.getCityList();
            //遍历城市列表
            for(City city : cityList) {
                log.info("cityId: {}", city.getCityId());
                weatherService.syncDataByCityId(city.getCityId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("error: {}", e);
        }
        log.info("weather data sync end");
    }

}

package com.weather.job;

import com.weather.service.CityService;
import com.weather.service.WeatherService;
import com.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * Weather Data Sync Job.
 */
@Slf4j
public class WeatherDataSyncJob {
//
//	@Autowired
//	private WeatherService weatherService;
//	@Autowired
//	private CityService cityService;
//
//	@Override
//	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//		log.info("Weather Data Sync Job. Start！");
//		try {
//			// 获取城市ID列表
//			List<City> cityList = cityService.getCityList();
//
//			// 遍历城市ID获取天气
//			for (City city : cityList) {
//				String cityId = city.getCityId();
//				log.info("Weather Data Sync Job, cityId:" + cityId);
//				weatherService.syncDataByCityId(cityId);
//			}
//		} catch (Exception e) {
//			log.error("error: {}", e);
//		}
//
//		log.info("Weather Data Sync Job. End！");
//	}

}

package com.gaiaworks.service;

import java.util.ArrayList;
import java.util.List;

import com.gaiaworks.vo.Forecast;
import com.gaiaworks.vo.Weather;
import com.gaiaworks.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

//	@Autowired
//	private WeatherDataClient weatherDataClient;
	@Autowired
	private ZuulClient zuulClient;
	
	public Weather getDataByCityId(String cityId) {
		//由天气数据API微服务来提供
		WeatherResponse weatherResponse = zuulClient.getDataByCityId(cityId);
		return weatherResponse.getData();
	}

}

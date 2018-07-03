package com.gaiaworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Created by 唐哲
 * 2018-03-01 13:01
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    private static final Long TIME_OUT = 1800L; //1800s 半小时

    public void syncDateByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    /**
     * 从服务接口读取天气数据，再把天气数据放在缓存
     */
    private void saveWeatherData(String uri) {
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        if(respString.getStatusCodeValue() == 200) {
            ValueOperations<String, String> ops = redisTemplate.opsForValue();
            //数据写入缓存
            ops.set(uri, respString.getBody(), TIME_OUT, TimeUnit.SECONDS);
        }
    }

}

package com.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by 唐哲
 * 2018-02-24 12:56
 */
@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;

    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }
    
    public void syncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    private static final Long TIME_OUT = 1800L; //1800s 半小时
    
    private WeatherResponse doGetWeather(String uri) {
        try {
            String strBody = null;
            ValueOperations<String, String> ops = redisTemplate.opsForValue();
            //先查缓存，缓存有则取缓存中的数据，缓存没有，则再调用服务接口来获取
            if(redisTemplate.hasKey(uri)) {
                //缓存有数据，查redis
                log.info("redis has data");
                strBody = ops.get(uri);
            } else {
                //缓存没有数据，调用接口
                log.info("redis has no data");
                ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
                if(respString.getStatusCodeValue() == 200) {
                    strBody = respString.getBody();
                    //将strBody存入redis
                    ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
                }
            }

            //将strBody转为WeatherResponse类型
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(strBody, WeatherResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("error: {}", e.getMessage());
            return null;
        }
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

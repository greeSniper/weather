package com.gaiaworks.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaiaworks.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * Created by 唐哲
 * 2018-03-01 13:18
 */
@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri) {
        try {
            String strBody = null;
            ValueOperations<String, String> ops = redisTemplate.opsForValue();
            //先查缓存，缓存有则取缓存中的数据，缓存没有，抛出异常
            if(redisTemplate.hasKey(uri)) {
                //缓存有数据，查redis
                log.info("redis has data");
                strBody = ops.get(uri);
            } else {
                //缓存没有数据，调用接口
                log.info("redis has no data");
                //缓存没有，抛出异常
                throw new RuntimeException("Don't has data!");
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

}

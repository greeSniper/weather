package com.gaiaworks.service;

import com.gaiaworks.utils.XmlBuilder;
import com.gaiaworks.vo.City;
import com.gaiaworks.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by 唐哲
 * 2018-02-24 15:59
 */
@Service
public class CityServiceImpl implements CityService {

    public List<City> getCityList() throws Exception {
        // 读取XML文件
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        while ((line = br.readLine()) !=null) {
            buffer.append(line);
        }

        br.close();

        // XML转为Java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToOject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }

}

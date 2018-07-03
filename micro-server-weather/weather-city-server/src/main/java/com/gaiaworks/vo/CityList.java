package com.gaiaworks.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * City List
 */
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CityList {

	@XmlElement(name = "d")
	private List<City> cityList;

}

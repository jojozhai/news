/**
 * 
 */
package com.imooc.news.domain;

import javax.persistence.Embeddable;

/**
 * @author zhailiang
 *
 */
@Embeddable
public class Address {
	
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市 
	 */
	private String city;
	/**
	 * 区 
	 */
	private String area;
	/**
	 * 详细地址
	 */
	private String location;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}

/**
 * 
 */
package com.imooc.news.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author zhailiang
 *
 */
@Entity
public class UserDetails extends Domain{
	
	/**
	 * 基本信息
	 */
	@OneToOne(mappedBy = "details")
	private User user;
	/**
	 * 爱好
	 */
	@ElementCollection
	private List<String> hobbies;
	/**
	 * 地址信息
	 */
	@ElementCollection
	private List<Address> addresses;
	
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
}

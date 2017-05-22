/**
 * 
 */
package com.imooc.news.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author zhailiang
 *
 */
@Entity
public class Category extends Domain {
	
	@OneToMany(mappedBy = "category")
	private List<News> newses;

	public List<News> getNewses() {
		return newses;
	}

	public void setNewses(List<News> newses) {
		this.newses = newses;
	}
	
	
	
}

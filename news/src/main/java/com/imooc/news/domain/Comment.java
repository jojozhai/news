/**
 * 
 */
package com.imooc.news.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author zhailiang
 *
 */
@Entity
public class Comment extends Domain {
	
	/**
	 * 资讯
	 */
	@ManyToOne
	private News news;
	/**
	 * 用户
	 */
	@ManyToOne
	private User user;
	/**
	 * 评论内容
	 */
	private String content;
	
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}

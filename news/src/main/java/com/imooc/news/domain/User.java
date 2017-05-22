/**
 * 
 */
package com.imooc.news.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author zhailiang
 *
 */
@Entity
public class User extends Domain {
	
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 头像
	 */
	private String headImg;
	/**
	 * 评论信息 
	 */
	@OneToMany(mappedBy = "user")
	private List<Comment> comments;
	/**
	 * 详细信息
	 */
	@OneToOne
	private UserDetails details;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	
}

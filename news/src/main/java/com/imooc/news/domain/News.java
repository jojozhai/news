/**
 * 
 */
package com.imooc.news.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * @author zhailiang
 *
 */
@Entity
public class News extends Domain {
	
	@ManyToOne
	private Category category;
	/**
	 * 评论信息
	 */
	@OneToMany(mappedBy = "news")
	private List<Comment> comments;
	
	/**
	 * 资讯状态
	 */
	@Enumerated(EnumType.STRING)
	private NewsStatus status;
	/**
	 * 资讯标题
	 */
	@Column(length = 50, nullable = false, unique = true)
	private String title;
	/**
	 * 浏览次数
	 */
	@Column(precision = 5, scale = 2)
	private BigDecimal price;
	/**
	 * 内容
	 */
	@Lob
	private String content;
	
	@Transient
	private String miniTitle;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getMiniTitle() {
		return title.substring(0,10);
	}

	public void setMiniTitle(String miniTitle) {
		this.miniTitle = miniTitle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public NewsStatus getStatus() {
		return status;
	}

	public void setStatus(NewsStatus status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}

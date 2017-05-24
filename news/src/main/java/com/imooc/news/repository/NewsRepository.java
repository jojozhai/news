/**
 * 
 */
package com.imooc.news.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.imooc.news.domain.News;

/**
 * @author zhailiang
 *
 */
public interface NewsRepository extends JpaRepository<News, Long>, JpaSpecificationExecutor<News>{
	
	News findByTitle(String title);
	
	Page<News> findByCreatedTimeBefore(Date date, Pageable pageable);
	
	@Query("select count(n.id) from News n where n.title = ?1")
	long countNews(String title);
	
	@Query("update News n set n.title = ?2 where n.id = ?1")
	@Modifying
	void updateTitle(Long id, String title);
	

}

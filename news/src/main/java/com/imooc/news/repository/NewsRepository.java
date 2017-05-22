/**
 * 
 */
package com.imooc.news.repository;

import org.springframework.data.repository.CrudRepository;

import com.imooc.news.domain.News;

/**
 * @author zhailiang
 *
 */
public interface NewsRepository extends CrudRepository<News, Long> {

}

/**
 * 
 */
package com.imooc.news.repository;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.news.domain.News;

/**
 * @author zhailiang
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsRepositoryTest {
	
	@Autowired
	private NewsRepository newsRepository;
	
	@Test
	@Transactional
	public void whenUpdateTitleSuccess() {
		newsRepository.updateTitle(1L, "test news");
	}
	
	@Test
	public void whenQuerySuccess3() {
		newsRepository.countNews("test news");
	}
	
	@Test
	public void whenQuerySuccess2() {
		newsRepository.findByCreatedTimeBefore(new Date(), new PageRequest(0, 5, Direction.DESC, "createdTime"));
	}
	
	
	@Test
	public void whenQuerySuccess() {
		newsRepository.findByTitle("test news");
	}
	
	/**
	 * Root : 我们要查询的对象，在这个例子中就是News.
	 * CriteriaQuery: 抽象了整个Sql查询，用来把查询中的各个段组合在一起，比如select段，where段,order段。
	 * CriteriaBuilder： 用来构建Predicate。
	 * Predicate: 就是我们的where语句。
	 */
	@Test
	public void whenQueryBySpecSuccess() {
		
		Specification<News> specification = new Specification(){
			@Override
			public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
				Path path = root.get("title");
				return cb.equal(path, "test news");
			}
			
		};
		
		newsRepository.findAll(specification, new PageRequest(0, 10, Direction.DESC, "createdTime"));
		
	}
	
	@Test
	public void whenQueryByExampleSuccess() {
		News news = new News();
		news.setTitle("test1");
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("title", match -> match.contains());
		
		newsRepository.findOne(Example.of(news, matcher));
	}
	
	@Test
	public void whenPagingSuccess(){
		Pageable pageable = new PageRequest(0, 10, new Sort(Direction.DESC, "createdTime"));
		Page<News> page = newsRepository.findAll(pageable);
	}
	
	@Test
	public void whenSortSuccess2() {
		newsRepository.findAll(new Sort(
				new Order(Direction.DESC, "createdTime"),
				new Order(Direction.ASC, "id")));
	}
	
	@Test
	public void whenSortSuccess() {
		newsRepository.findAll(new Sort(Direction.DESC, "createdTime"));
	}
	
	@Test
	public void whenDeleteSuccess() {
		newsRepository.delete(1L);
	}
	
	@Test
	public void whenCountSuccess() {
		
		long count = newsRepository.count();
		System.out.println(count);
	}
	
	@Test
	public void whenFindAllSuccess() {
		
		Iterable<News> newses = newsRepository.findAll();
		
		for (News news : newses) {
			System.out.println(news.getTitle());
		}
	}
	
	@Test
	@Transactional
	public void whenFindOneSuccess() {
		
		News news = newsRepository.findOne(1L);
		
		newsRepository.findOne(1L);
		
		Assert.assertEquals("test1", news.getTitle());
		
	}
	
	@Test
	@Transactional
	@Commit
	public void whenUpdateSuccess() {
		
		News news = newsRepository.findOne(1L);
		news.setTitle("test news");
		
	}
	
	@Test
	public void whenSaveSuccess() {
		
		News news = new News();
		news.setTitle("test2");
		newsRepository.save(news);
		
	}
	
	@Test
	public void testNewsRepository() {
		System.out.println(newsRepository.toString());
	}

}

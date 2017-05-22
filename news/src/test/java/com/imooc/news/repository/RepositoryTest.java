/**
 * 
 */
package com.imooc.news.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhailiang
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
	
	@Autowired
	private NewsRepository newsRepository;
	
	@Test
	public void whenFindAllSuccess() {
		newsRepository.findAll();
	}

}

/**
 * 
 */
package com.imooc.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhailiang
 *
 */
@SpringBootApplication
@RestController
public class NewsApplication {
	
	@Autowired
	private GreetingRepository greetingRepository;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}
	
	@RequestMapping("/greeting")
	public Greeting greeting(String name) {
		Greeting greeting = new Greeting();
		greeting.setName(name);
		greetingRepository.save(greeting);
		return greeting;
	}

}

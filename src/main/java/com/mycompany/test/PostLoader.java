package com.mycompany.test;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mycompany.test.Entities.Post;
import com.mycompany.test.Repositories.PostRepository;

//Loads sample data.
@Component
public class PostLoader implements ApplicationListener<ContextRefreshedEvent>{

	private PostRepository postRepo;
	
	private Logger log = Logger.getLogger(PostLoader.class);
	
	@Autowired
	public void setPostRepository(PostRepository postRepo) {
		this.postRepo = postRepo;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Random rand = new Random();
		int num = rand.nextInt(1000);
		for(int i=0;i<10;i++) {			
			Post post = new Post();
			post.setTitle("Test");
			post.setMessage(RandomStringUtils.randomAscii(num));
			postRepo.save(post);		
			log.info("new post - id: " + post.getPostId());
		}	
		
	}
}

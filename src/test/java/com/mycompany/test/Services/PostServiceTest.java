package com.mycompany.test.Services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mycompany.test.Application;
import com.mycompany.test.Configuration.RepositoryConfiguration;
import com.mycompany.test.Entities.Post;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RepositoryConfiguration.class, PostService.class, PostServiceImpl.class })
public class PostServiceTest {

	private PostService postService;
	private Post post;
	
	@Autowired
	public void setPostService(PostService postService) throws Exception{
		this.postService = postService;
	}
	
	@Before
	public void setup() throws Exception{
		post = new Post();
		post.setMessage("Message");
		post.setTitle("Title");
		postService.savePost(post);
	}
	
	@Test
	public void listAllPostsTest() throws Exception{
		Iterable<Post> posts = postService.listAllPosts();
		int count = 0;
		for(Post post:posts) {
			count++;
		}
		
		assertEquals(count,1);
	}
	
	@Test
	public void getPostByIdTest() throws Exception{
		Post test = postService.getPostById(post.getPostId());
		assertEquals(test.getPostId(),post.getPostId());
		assertEquals(test.getTitle(), post.getTitle());
		assertEquals(test.getMessage(), post.getMessage());
	}
	
	@Test
	public void savePostTest() throws Exception{
		Post test = new Post();
		test.setMessage("testmsg");
		test.setTitle("testTitle");
		postService.savePost(test);
		
		Post saved = postService.getPostById(test.getPostId());
		assertEquals(test.getPostId(),saved.getPostId());
		assertEquals(test.getTitle(), saved.getTitle());
		assertEquals(test.getMessage(), saved.getMessage());

	}
	
	
	
}

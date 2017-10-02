package com.mycompany.test.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.test.Entities.Post;
import com.mycompany.test.Repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService{

	private PostRepository postRepo;
	
	@Autowired
	public void setPostRepository(PostRepository postRepo) {
		this.postRepo = postRepo;
	}
	
	@Override
	public Iterable<Post> listAllPosts(){
		return postRepo.findAll();
	}
	 
	@Override
	public Post getPostById(Long id) {
		return postRepo.findOne(id);
	}
	
	@Override
	public Post savePost(Post post) {
		return postRepo.save(post);
	}
	
	public void deletePost(Post post) {
		postRepo.delete(post);
	}

}

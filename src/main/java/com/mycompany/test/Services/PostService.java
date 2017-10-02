package com.mycompany.test.Services;

import com.mycompany.test.Entities.Post;

public interface PostService {

	Iterable<Post> listAllPosts();
	
	Post getPostById (Long id);
	
	Post savePost (Post post);	
	
	void deletePost (Post post);

}

package com.mycompany.test.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.test.Entities.Post;
import com.mycompany.test.Services.PostService;

@Controller
public class PostController {
 
		private PostService postService;
		
		@Autowired
		public void setPostService(PostService postService) {
			this.postService = postService;
		}
		
		@RequestMapping(value="/posts", method=RequestMethod.GET)
		public String listAllPosts(Model model) {
			model.addAttribute("posts", postService.listAllPosts());
			return "posts";
		}
		
		@RequestMapping("posts/{postId}")
		public String showPost(@PathVariable long postId, Model model) {
			model.addAttribute("post", postService.getPostById(postId));
			return "postshow"; 
		}

		@RequestMapping("posts/new")
		public String newPost(Model model) {
			model.addAttribute("post", new Post());
			return "postform";
		}
		
		@RequestMapping("about")
		public String showAbout(Model model) {
			return "about";
		}
		
		@RequestMapping(value="posts/edit/{postId}")
		public String editPost(@PathVariable long postId, Model model) {
			model.addAttribute("post", postService.getPostById(postId));
			return "postform";
		}
		
		@RequestMapping(value="post", method=RequestMethod.POST)
		public String savePost(Post post) {
			postService.savePost(post);
			return "redirect:/posts/" + post.getPostId();
		}
		
		@RequestMapping(value="delete/{postId}", method=RequestMethod.GET)
		public String deletePost(@PathVariable long postId) {
			Post post = postService.getPostById(postId);
			postService.deletePost(post);
			return "redirect:/posts";
		}
		
		
}

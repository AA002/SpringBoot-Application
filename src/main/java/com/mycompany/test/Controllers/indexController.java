package com.mycompany.test.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mycompany.test.Services.PostService;

@Controller
public class indexController {

	private PostService postService;
	
	@Autowired
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("posts", postService.listAllPosts());
		return "index";
	}
}
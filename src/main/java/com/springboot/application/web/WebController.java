package com.springboot.application.web;

import com.springboot.application.webservice.PostsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@Slf4j
public class WebController {
	private PostsService postsService;

	@GetMapping
	public String main (Model model) {
		model.addAttribute("posts", postsService.findAllDesc());
		return "main";
	}
}

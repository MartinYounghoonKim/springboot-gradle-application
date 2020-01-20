package com.springboot.application.web;

import com.springboot.application.domain.posts.PostsRepository;
import com.springboot.application.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {
    private PostsRepository postsRepository;
    @GetMapping("/hello")
    public String hello() {
        return "Hello, this is Martin's tutorial.";
    }

    @PostMapping("/post")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }
}

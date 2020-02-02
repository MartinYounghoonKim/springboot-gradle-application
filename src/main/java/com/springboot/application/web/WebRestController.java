package com.springboot.application.web;

import com.springboot.application.domain.posts.PostsRepository;
import com.springboot.application.dto.PostsMainResponseDto;
import com.springboot.application.dto.PostsSaveRequestDto;
import com.springboot.application.webservice.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class WebRestController {
    private PostsService postsService;
    @GetMapping("/hello")
    public String hello() {
        return "Hello, this is Martin's tutorial.";
    }

    @GetMapping("/")
    public List<PostsMainResponseDto> main () {
        List<PostsMainResponseDto> list =  postsService.findAllDesc();
        return list;
    }
    @PostMapping("/post")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }
}

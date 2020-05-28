package com.springboot.application.web;

import com.springboot.application.dto.PostsMainResponseDto;
import com.springboot.application.dto.PostsSaveRequestDto;
import com.springboot.application.webservice.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WebRestController {
    private PostsService postsService;
    @Value("${spring.profiles.active}")
    String active;

    @GetMapping("/profile")
    public String getProfile() {
        return active;
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

    @DeleteMapping("/post/{id}")
    public Long deletePost(@PathVariable Long id) {
        try {
            return postsService.delete(id);
        } catch (Exception e) {
            return 1111L;
        }
    }
}

package com.springboot.application.web;

import com.springboot.application.dto.PostsMainResponseDto;
import com.springboot.application.dto.PostsSaveRequestDto;
import com.springboot.application.webservice.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class WebRestController {
    private PostsService postsService;
    private Environment environment;
    @GetMapping("/profile")
    public String getProfile() {
        return Arrays.stream(environment.getActiveProfiles())
            .findFirst()
            .orElse("");
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

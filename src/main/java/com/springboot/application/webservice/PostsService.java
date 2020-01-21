package com.springboot.application.webservice;

import com.springboot.application.domain.posts.PostsRepository;
import com.springboot.application.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class PostsService {
	private PostsRepository postsRepository;
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
}

package com.springboot.application.webservice;

import com.springboot.application.domain.posts.PostsRepository;
import com.springboot.application.dto.PostsMainResponseDto;
import com.springboot.application.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
	private PostsRepository postsRepository;
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}

	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc () {
		return postsRepository.findAllDesc()
				.map(PostsMainResponseDto::new)
				.collect(Collectors.toList());
	}

	@Transactional
	public Long delete(Long id) throws Exception {
		try {
			postsRepository.deleteById(id);
			return id;
		} catch (EmptyResultDataAccessException e) {
			throw new Exception("dddddd");
		} catch (IllegalArgumentException e) {
			return 111111111111L;
		}
	}
}

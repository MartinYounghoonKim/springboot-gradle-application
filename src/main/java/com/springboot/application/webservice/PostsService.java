package com.springboot.application.webservice;

import com.springboot.application.domain.posts.PostRepositorySupport;
import com.springboot.application.domain.posts.Posts;
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
	private PostRepositorySupport postRepositorySupport;
	private PostsRepository postsRepository;
//	javax 에도 Transactional이 있기 때문에 헷갈리지 않도록..
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}

	/**
	 * readOnly = true 옵션을 줄 시,
	 * 트랜젝션 범위는 유지하되 조회 기능만 남겨두어 조회 속도가 개선
	 * SO, 등록/수정/삭제 기능이 없는 메소드에서 사용하는 것을 추천
	 * Transactional 에 대한 자세한 설명은 https://goddaehee.tistory.com/167
	 */
	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc () {
		return postsRepository.findAllDesc()
			.map(PostsMainResponseDto::new)
			.collect(Collectors.toList());
	}

	@Transactional
	public List<Posts> testing () {
		return postRepositorySupport.findAll();
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

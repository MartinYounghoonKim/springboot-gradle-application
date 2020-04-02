package com.springboot.application.dto;

import com.springboot.application.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class PostsMainResponseDto {
	private Long id;
	private String title;
	private String content;
	private String author;
	private String modifiedDate;

	public PostsMainResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.author = entity.getAuthor();
		this.modifiedDate =  toStringDateTime(entity.getModifiedDate());
	}

	private String toStringDateTime(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return Optional.ofNullable(localDateTime)
			.map(formatter::format)
			.orElse("");
	}
}

package com.springboot.application.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

/**
 * MyBatis 등에서 Dao라고 불리는 DB Layer 접근자
 * JPA에서는 Repository라고 부르며, 인터페이스로 생성한다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
	@Query("SELECT p " +
		"FROM Posts p " +
		"ORDER BY p.id DESC")
	Stream<Posts> findAllDesc();

	List<Posts> findAll();
}

package com.springboot.application.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

/**
 * MyBatis 등에서 Dao라고 불리는 DB Layer 접근자
 * JPA에서는 Repository라고 부르며, 인터페이스로 생성한다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
    // SpringDataJpa 에서 제공해주지 않는 경우 아래와 같이 직접 Query 를 작성해도 된다.
    @Query("SELECT p " +
            "FROM Posts p "
            + "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}

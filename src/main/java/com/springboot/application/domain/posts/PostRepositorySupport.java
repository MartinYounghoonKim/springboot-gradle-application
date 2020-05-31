package com.springboot.application.domain.posts;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.springboot.application.domain.posts.QPosts.posts;

@Repository
public class PostRepositorySupport extends QuerydslRepositorySupport {
	private final JPAQueryFactory queryFactory;  // bean 으로 등록된 JPAQueryFactory 주입

	public PostRepositorySupport(JPAQueryFactory queryFactory) {
		super(Posts.class); // Entity class 를 넣어주고
		this.queryFactory = queryFactory;
	}

	public List<Posts> findAll () {
		return queryFactory
			.selectFrom(posts)
			.where(posts.author.eq("martin"))
			.fetch();
	}
}

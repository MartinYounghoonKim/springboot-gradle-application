package com.springboot.application.web;

//import com.example.demo.entity.QHelloEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.application.domain.HelloEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequiredArgsConstructor
public class HelloController {
	@Autowired
	EntityManager em;

	@GetMapping
	public String hello () {
		HelloEntity helloEntity = new HelloEntity();
		em.persist(helloEntity);

		JPAQueryFactory queryFactory =  new JPAQueryFactory(em);
//		QHelloEntity qHelloEntity = QHelloEntity.helloEntity;

//		HelloEntity result = queryFactory
//			.selectFrom(qHelloEntity)
//			.fetchOne();

//		System.out.println(result);
		return "Hello";
	}
}

package com.springboot.application;

import com.springboot.application.domain.BaseTimeEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @EnableJpaAuditing
 * JPA Auditing 활성화
 * @see BaseTimeEntity 와 관계 있음
 */
@EnableJpaAuditing //
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

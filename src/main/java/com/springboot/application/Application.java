package com.springboot.application;

import com.springboot.application.domain.BaseTimeEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @EnableJpaAuditing
 * JPA Auditing 활성화
 * @see BaseTimeEntity 와 관계 있음
 */
@EnableJpaAuditing //
@SpringBootApplication
public class Application {
    public static final String APPLICATION_LOCATIONS = "spring.config.location="
        + "classpath:application.yml,"
        + "/app/config/springboot-webservice/real-application.yml";
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
            .properties(APPLICATION_LOCATIONS)
            .run(args);
    }

}

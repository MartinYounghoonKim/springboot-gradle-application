/**
 * @Lombok
 * 1. IntelliJ 설치(ref: https://blog.woniper.net/229)
 * 2. 사용상 주의점(ref: https://kwonnam.pe.kr/wiki/java/lombok/pitfall)
 */
package com.springboot.application.domain.posts;

import com.springboot.application.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @NoArgsConstructor
 * 1. 기본 생성자 자동 추가
 * 2. access = AccessLevel.PROTECTED: 기본 생성자의 접근 권한을 protected로 제한
 *
 * @Getter
 * 1. 클래스 내의 모든 필드의 Getter 메소드를 자동 생성
 *
 * @Builder
 * 1. 해당 클래스의 빌더 패턴 클래스를 생성
 *
 * @Entity
 * 1. 테이블과 링크될 클래스임을 나타냄. 언더스코어 네이밍으로 매칭 ex)UserTable -> user_table
 */
@NoArgsConstructor
@Getter
@Entity
public class Posts extends BaseTimeEntity {
    /**
     * 실제 DB의 테이블과 매칭될 클래스이며 보통 Entity Class 라고 함
     */

    /**
     * @Id
     * 1. 해당 테이블에 대한 PK 값을 의미
     * 2. PK 값의 타입은 Long 타입의 auto_increment를 추천(MYSQL 기준, BIGINT 타입이 됨)
     * @GeneratedValue PK 생성 규칙을 나타냄. 기본값은 AUTO으로 MYSQL의 auto_increment 와 동일
     * Springboot 2.0 에선 옵션 추가를 해야한다고 함(@ref https://jojoldu.tistory.com/295)
     * GeneratedValue에 대한 자세한 설명은 https://www.popit.kr/%ED%95%98%EC%9D%B4%EB%B2%84%EB%84%A4%EC%9D%B4%ED%8A%B8%EB%8A%94-%EC%96%B4%EB%96%BB%EA%B2%8C-%EC%9E%90%EB%8F%99-%ED%82%A4-%EC%83%9D%EC%84%B1-%EC%A0%84%EB%9E%B5%EC%9D%84-%EA%B2%B0%EC%A0%95%ED%95%98/
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * @Column
     * 테이블의 컬럼을 나타냄.
     * 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 된다고 함. But, 아래와 같이 기본값 외에 변경이 필요한 옵션이 있을 경우 사용
     */
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

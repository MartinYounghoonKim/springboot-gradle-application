### LocalDate 사용
Java의 기본 날짜 타입인 Date의 문제점을 고친 타입으로 Java8 부터는 LocalDate와 LocalDateTime 을 주로 사용한다고 함

- 기존 Date의 단점 https://d2.naver.com/helloworld/645609
### URL
- [h2-console](http://localhost:8080/h2-console/login.do?jsessionid=5136b3d26e67e51526441f8ced8c3ece) 


### h2 database connection 안될때
JDBC Url 부분에 `jdbc:h2:~/test`를 `jdbc:h2:mem:testdb`로 변경해주어야 함

### Trouble Shooting
#### Gradle Local cache로 인한 빌드 실패

```bash
rm -R /Users/[USER_NAME]/.gradle
```

#### Gradle Version 변경

```bash
./gradlew wrapper --gradle-version=5.6.4
```

#### Gradle build 실패
`No cached version of available for offline mode` 와 같은 에러가 뜰 때

```bash
./gradlew build --stacktrace
```

### Reference
- https://www.daleseo.com/java8-optional-effective/
- https://jeong-pro.tistory.com/m/165


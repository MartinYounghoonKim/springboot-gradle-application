## Trouble shooting

---

### h2 database connection 안될때
JDBC Url 부분에 `jdbc:h2:~/test`를 `jdbc:h2:mem:testdb`로 변경해주어야 함

### Gradle Local cache로 인한 빌드 실패

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
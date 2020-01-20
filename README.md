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

# Mac에서 Redis 설치
```
1. 설치
 - brew install redis
2. 버전 확인
 - redis-server --version
3. 실행
 - brew services start redis
4. 중단
 - brew services stop redis
5. 터미널 접속
 - redis-cli -h localhost -p 6379
6. 전체 키 조회
 - kyes *
7. 전체 키 삭제
 - flushall
```

# 의존성
```
implementation 'org.springframework.boot:spring-boot-starter-data-redis'
```
# application.yml
```
spring:
    redis:
        lettuce:
            pool:
                min-idle: 0
                max-idle: 8
                max-active: 8
        port: 6379
        host: localhost
```
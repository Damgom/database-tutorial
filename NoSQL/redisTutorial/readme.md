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

## 간단한 회원가입 로직을 추가하고 회원가입 진행
![image](https://user-images.githubusercontent.com/104135990/218467976-f6e5cc3b-fc33-44a6-8078-a615d65ca812.png)

## 회원이름으로 조회했을 때 key(id)값을 잘 읽어오는지 확인
![image](https://user-images.githubusercontent.com/104135990/218468145-43ca14ba-1c83-4c97-b5b1-32b9504df337.png)

## 회원가입을 2번 진행하고 key값의 개수를 확인
![image](https://user-images.githubusercontent.com/104135990/218468468-b6b3471c-3e00-4288-a7a0-73dae7bb6ff9.png)


# 특징
- Key-value DB
- 하드디스크에 저장 x, ram에 저장 (속도가 빠르다)
- 메인DB를 두고 자주 쓰는 데이터들을 redis에 추가로 복사, 그 데이터가 필요한 경우 redis에서 조회한다. (데이터 캐싱)
- 로그인 기록 저장(access token, refresh token)

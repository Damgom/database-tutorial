# 설치
```
> brew tap mongodb/brew
> brew install mongodb-community-shell

MongoDB 버전 확인
> mongo -version

MongoDB 데이터 저장소 생성
> sudo mkdir -p /Users/${username}/data/db

MongoDB 서비스 실행
> brew services start mongodb-community

MongoDB 서비스 종료
> brew services stop mongodb-community

MongoDB 기본 포트 확인
> lsof -i:27017

```

# 의존성
```
단독으로 사용 할 경우
implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'

다른 db와 함께 사용 할 경우
implementation 'org.springframework.boot:spring-boot-starter-data-mongodb-reactive'
```

# MongoDB 명령어

## CREATE

## READ

## UPDATE

## DELETE
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

# yml

```
spring:
  data:
    mongodb:
      host: localhost
      port: 27017
      authentication-database: admin
      database: testdb
```

# MongoDB 명령어

## CREATE
```
DB
> use {dbname}
- dbname으로 db생성 혹은 switch

Collection&Document
> db.collection.insert(
  [document or array of documents],
  {
    writeConcern: [document],
    ordered: [boolean] # true면 document array의 인덱스 순으로 insert. default는 True
  }
)
WriteResult({ "nInserted" : 1 })
document 하나를 insert하면 collection이 함께 생성
```

## READ

```
DB
> show dbs
database list를 출력

> db
사용중인 db를 확인

Collection
> show collections
collection 목록 확인

> db.getCollectionNames()
collection 목 확인

용량확인
> use [dbname]
> db.stats()
```
## UPDATE

## DELETE
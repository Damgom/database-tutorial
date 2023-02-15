# MySQL remind

## Dependency
```
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
```

## yml
```
h2 database 사용시
spring:
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
  h2:
    console:
      enabled: true
      path: /h2
  datasource:
    url: jdbc:h2:mem:test
  jpa:
    hibernate:
      ddl-auto: create
    show-sql: true
    open-in-view: false
    
MySQL 사용시
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/{mydatabase}
    username: {username}
    password: {password}
  jpa:
    database: mysql
    database-platform: org.hibernate.dialect.MySQL5InnoDBDialect
    hibernate:
      ddl-auto: create
    show-sql: true
    properties:
      hibernate:
        format-sql: true
    open-in-view: false
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
```


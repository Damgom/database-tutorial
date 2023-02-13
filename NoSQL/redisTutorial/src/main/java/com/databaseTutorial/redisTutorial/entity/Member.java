package com.databaseTutorial.redisTutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "member", timeToLive = 30)
public class Member {

    @Id
    private String id;
    @Indexed
    private String name;
    private int age;
    private LocalDateTime createdAt;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
        this.createdAt = LocalDateTime.now();
    }
}

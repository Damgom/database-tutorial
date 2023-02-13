package com.databaseTutorial.redisTutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "people", timeToLive = 30)
public class Member {

    @Id
    private String id;
    private String name;
    private int age;
    private LocalDateTime createdAt;
}

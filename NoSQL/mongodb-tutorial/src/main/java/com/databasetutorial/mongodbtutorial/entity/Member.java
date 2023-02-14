package com.databasetutorial.mongodbtutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "member")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    private String id;
    private String name;
    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

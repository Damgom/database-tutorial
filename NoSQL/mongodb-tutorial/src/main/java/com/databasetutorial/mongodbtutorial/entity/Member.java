package com.databasetutorial.mongodbtutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Document(collection = "member")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    private String id;
    private String name;
    private String email;
    private List<String> follower = new ArrayList<>();
    private List<String> following = new ArrayList<>();

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void update(Member updateMember) {
        Optional.ofNullable(updateMember.getEmail()).ifPresent(n -> this.email = updateMember.getEmail());
        Optional.ofNullable(updateMember.getName()).ifPresent(n -> this.name = updateMember.getName());
    }
}

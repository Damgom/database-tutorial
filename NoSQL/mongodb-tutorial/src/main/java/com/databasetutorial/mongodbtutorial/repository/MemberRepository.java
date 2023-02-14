package com.databasetutorial.mongodbtutorial.repository;

import com.databasetutorial.mongodbtutorial.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MemberRepository extends MongoRepository<Member, String> {
    Optional<Member> findByName(String name);
}

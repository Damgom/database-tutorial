package com.databaseTutorial.redisTutorial.repository;

import com.databaseTutorial.redisTutorial.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, String> {
    Optional<Member> findByName(String name);
}

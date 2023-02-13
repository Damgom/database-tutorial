package com.databaseTutorial.redisTutorial.repository;

import com.databaseTutorial.redisTutorial.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
}

package com.databasetutorial.mongodbtutorial.repository;

import com.databasetutorial.mongodbtutorial.entity.Member;
import com.databasetutorial.mongodbtutorial.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberService memberService;

    @BeforeEach()
    void before() {
        memberRepository.deleteAll();
    }
    @Test
    void test() {
        //given
        Member member = new Member("damgom", "damgom@gmail.com");
//        memberRepository.save(member);
        memberService.saveMember("damgom", "damgom@gmail.com");
        //when
        Member member1 = memberRepository.findByName("damgom").orElseThrow(() -> new RuntimeException("error"));
        //then
        assertThat(member.getEmail()).isEqualTo(member1.getEmail());
    }
}
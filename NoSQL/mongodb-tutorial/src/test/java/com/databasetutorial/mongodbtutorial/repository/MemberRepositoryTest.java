package com.databasetutorial.mongodbtutorial.repository;

import com.databasetutorial.mongodbtutorial.entity.Member;
import com.databasetutorial.mongodbtutorial.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        Member member2 = memberRepository.findById(member1.getId()).orElseThrow(() -> new RuntimeException("e"));
        //then
        assertThat(member.getEmail()).isEqualTo(member1.getEmail());
        assertThat(member.getEmail()).isEqualTo(member2.getEmail());
    }

    @DisplayName("팔로우")
    @Test
    void test2() {
        //given
        Member member = new Member("damgom", "damgom@gmail.com");
        Member member2 = new Member("damgom2", "damgom2@gmail.com");
        Member member3 = new Member("damgom3", "damgom3@gmail.com");
        //when
        memberService.followMember(member.getName(), member2.getName());
        memberService.followMember(member.getName(), member3.getName());
        Member findMember = memberRepository.findByName("damgom").orElseThrow(() -> new RuntimeException("e"));
        String temp1 = findMember.getFollower().get(0);
        String temp2 = findMember.getFollower().get(1);
        //then
        assertThat(member.getFollower()).hasSize(2);
        assertThat(temp1).isEqualTo(member2.getId());
        assertThat(temp2).isEqualTo(member3.getId());
    }

}
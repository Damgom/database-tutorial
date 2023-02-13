package com.databaseTutorial.redisTutorial;

import com.databaseTutorial.redisTutorial.entity.Member;
import com.databaseTutorial.redisTutorial.repository.MemberRepository;
import com.databaseTutorial.redisTutorial.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class RedisRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberService memberService;

    @Test
    void test() {
        //given
        Member member = new Member("Damgom", 4);
        Member member1 = new Member("Goroke", 3);
        //when
        memberRepository.save(member);
        memberRepository.save(member1);
        String key1 = memberService.checkId("Damgom");
        Member findMember = memberRepository.findByName("Damgom").orElseThrow(() -> new RuntimeException("error"));
        //then
        assertThat(memberRepository.count()).isEqualTo(2);
        assertThat(key1).isEqualTo(findMember.getId());
    }
}

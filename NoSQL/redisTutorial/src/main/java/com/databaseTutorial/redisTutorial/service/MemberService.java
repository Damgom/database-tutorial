package com.databaseTutorial.redisTutorial.service;

import com.databaseTutorial.redisTutorial.entity.Member;
import com.databaseTutorial.redisTutorial.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public String join(String name, int age) {
        Member member = new Member(name, age);
        memberRepository.save(member);
        return "join success";
    }

    public String checkId(String name) {
        Member member = memberRepository.findByName(name).orElseThrow(
                () -> new RuntimeException("member not exists"));
        return member.getId();
    }

    public long checkMemberCount() {
        return memberRepository.count();
    }

    public void deleteMember(String name) {
        Member member = memberRepository.findByName(name).orElseThrow(
                () -> new RuntimeException("member not exists"));
        memberRepository.delete(member);
    }
}

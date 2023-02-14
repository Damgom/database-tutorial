package com.databasetutorial.mongodbtutorial.service;

import com.databasetutorial.mongodbtutorial.entity.Member;
import com.databasetutorial.mongodbtutorial.repository.MemberRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public String saveMember(String name, String email) {
        Member member = new Member(name, email);
        memberRepository.save(member);
        return "join success";
    }

    public String selectMember(String name) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Member member = memberRepository.findByName(name).orElseThrow(() -> new RuntimeException("not exist!"));
            return objectMapper.writeValueAsString(member);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "error";
        }
    }
}

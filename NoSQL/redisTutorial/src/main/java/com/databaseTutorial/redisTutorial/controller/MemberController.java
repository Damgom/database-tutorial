package com.databaseTutorial.redisTutorial.controller;

import com.databaseTutorial.redisTutorial.repository.MemberRepository;
import com.databaseTutorial.redisTutorial.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostMapping("/join")
    public String join(@RequestParam String name,
                       @RequestParam int age) {
        return memberService.join(name, age);
    }

    @GetMapping("/get")
    public String checkMember(@RequestParam String name) {
        return memberService.checkId(name);
    }

    @GetMapping("/check")
    public long memberCount() {
        return memberService.checkMemberCount();
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String name) {
        memberService.deleteMember(name);
    }
}

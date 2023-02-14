package com.databasetutorial.mongodbtutorial.controller;

import com.databasetutorial.mongodbtutorial.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public String join(@RequestParam String name,
                       @RequestParam String email) {
        return memberService.saveMember(name, email);
    }

    @GetMapping("/find")
    public String find(@RequestParam String name) {
        return memberService.selectMember(name);
    }
}

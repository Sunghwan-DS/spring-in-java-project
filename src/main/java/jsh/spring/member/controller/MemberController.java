package jsh.spring.member.controller;

import jsh.spring.member.domain.Member;
import jsh.spring.member.infra.MemberService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public void signUp(Member member) {
        memberService.join(member);
    }

    public Member getMember(Long memberId) {
        return memberService.findMember(memberId);
    }
}

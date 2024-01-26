package jsh.java.member.controller;

import jsh.java.member.domain.Member;
import jsh.java.member.infra.MemberService;

public class MemberController {

    // private final MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
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

package jsh.java.config;

import jsh.java.member.controller.MemberController;
import jsh.java.member.infra.MemberRepository;
import jsh.java.member.infra.MemberService;
import jsh.java.member.infra.MemberServiceImpl;
import jsh.java.member.infra.MemoryMemberRepository;

public class AppConfig {

    public MemberController memberController() {
        return new MemberController(memberService());
    }
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

package jsh.java.member.controller;

import jsh.java.config.AppConfig;
import jsh.java.member.domain.Grade;
import jsh.java.member.domain.Member;
import jsh.java.member.infra.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberControllerTest {

    private final AppConfig appConfig = new AppConfig();

    @Test
    @DisplayName("스프링 회원가입 테스트")
    void signUpTest() {

        MemberController memberController = appConfig.memberController();
        MemberRepository memberRepository = appConfig.memberRepository();

        Member member = new Member(1L, "이름", Grade.BASIC);
        memberController.signUp(member);

        Assertions.assertEquals(member, memberRepository.findById(member.getId()));
    }
}

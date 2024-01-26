package jsh.spring.member.controller;

import jsh.spring.member.domain.Grade;
import jsh.spring.member.domain.Member;
import jsh.spring.member.infra.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberControllerTest {

    @Autowired
    MemberController memberController;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("스프링 회원가입 테스트")
    void signUpTest() {
        Member member = new Member(1L, "이름", Grade.BASIC);
        memberController.signUp(member);

        Assertions.assertEquals(member, memberRepository.findById(member.getId()));
    }
}

package jsh.spring.member.infra;

import jsh.spring.member.domain.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}

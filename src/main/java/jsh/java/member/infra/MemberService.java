package jsh.java.member.infra;

import jsh.java.member.domain.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}

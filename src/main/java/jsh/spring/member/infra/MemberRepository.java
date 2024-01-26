package jsh.spring.member.infra;

import jsh.spring.member.domain.Member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}

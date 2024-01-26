package jsh.java.member.infra;

import jsh.java.member.domain.Member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}

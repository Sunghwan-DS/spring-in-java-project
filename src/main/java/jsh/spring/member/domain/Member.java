package jsh.spring.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Member {

    @Getter
    private Long id;
    private String name;
    private Grade grade;
}

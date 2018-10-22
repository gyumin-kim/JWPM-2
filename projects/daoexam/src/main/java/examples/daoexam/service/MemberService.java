package examples.daoexam.service;

import examples.daoexam.dto.Member;

import java.util.List;

public interface MemberService {
    public Member addMember(Member member);
    public Member getMember(String email);
}

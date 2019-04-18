package com.nerdlk.spring.service;

import java.util.List;

import com.nerdlk.spring.model.Member;
import com.nerdlk.spring.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MemberService")
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member findMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Member member, Long id) {
        Member updateMember = memberRepository.findById(id).orElse(null);
        if(updateMember != null) {
            updateMember.setFirstName(member.getFirstName());
            updateMember.setLastName(member.getLastName());
        }
        final Member myMember=  memberRepository.save(updateMember);
        return myMember;
    }

    public boolean deleteMember(Long id) {
        Member deleteMember = memberRepository.findById(id).orElse(null);
        if(deleteMember != null) {
            memberRepository.delete(deleteMember);
            return true;
        }

        return false;
    }
}
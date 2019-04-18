package com.nerdlk.spring.repository;

import com.nerdlk.spring.model.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("memberRepository")
public interface MemberRepository
       extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
}
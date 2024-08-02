package com.dongne.its.base.service.common;

import com.dongne.its.base.dao.MemberRepository;
import com.dongne.its.base.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member findBySignId(String signId) {
        return memberRepository.findBySignId(signId);
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    public Member findById(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        return optionalMember.orElse(null);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}

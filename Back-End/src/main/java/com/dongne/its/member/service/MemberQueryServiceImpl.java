package com.dongne.its.member.service;

import com.dongne.its.member.domain.Member;
import com.dongne.its.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements  MemberQueryService{

    private final MemberRepository memberRepository;

    @Override
    public Member findMemberById(Long id) {
        return memberRepository.findMemberById(id).orElseThrow();
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAllMembers();
    }

    @Override
    public List<Member> findMembersByIdAndProjectId(Long id, Long projectId) {
        return null;
    }

    @Override
    public List<Member> findMembersByIdAndProjectIdAndRole(Long id, Long projectId, String role) {
        return null;
    }
}

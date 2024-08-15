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
    public List<Member> findMembersByProjectId(Long projectId) {
        return memberRepository.findByProjectId(projectId);
    }

    @Override
    public List<Member> findMembersByProjectIdAndRole(Long projectId, String role) {
        return memberRepository.findByProjectIdAndRole(projectId, role);
    }
}

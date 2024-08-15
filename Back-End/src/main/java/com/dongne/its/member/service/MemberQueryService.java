package com.dongne.its.member.service;

import com.dongne.its.member.domain.Member;

import java.util.List;

public interface MemberQueryService {

    public Member findMemberById(Long id);

    public List<Member> findMembers();

    public List<Member> findMembersByProjectId(Long projectId);

    public List<Member> findMembersByProjectIdAndRole(Long projectId, String role);
}

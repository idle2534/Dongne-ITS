package com.dongne.its.member.service;

import com.dongne.its.member.domain.Member;

import java.util.List;

public interface MemberQueryService {

    public Member findMemberById(Long id);

    public List<Member> findMembers();

    public List<Member> findMembersByIdAndProjectId(Long id, Long projectId);

    public List<Member> findMembersByIdAndProjectIdAndRole(Long id, Long projectId, String role);
}

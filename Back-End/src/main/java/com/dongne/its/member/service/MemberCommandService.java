package com.dongne.its.member.service;

import com.dongne.its.member.domain.Member;
import com.dongne.its.member.domain.enums.Role;
import com.dongne.its.member.web.dto.MemberDeleteRequestDto;
import com.dongne.its.member.web.dto.MemberRoleUpdateRequestDto;
import com.dongne.its.member.web.dto.MemberSignInRequestDto;
import com.dongne.its.member.web.dto.MemberSignUpRequestDto;

public interface MemberCommandService {

    public void checkRole(Member member, Role role);

    public void checkPermissoion(Member member, Role role);

    public Member updateRole(MemberRoleUpdateRequestDto request);

    public Member delete(MemberDeleteRequestDto request);

    public Member signUp(MemberSignUpRequestDto request);

    public Member signIn(MemberSignInRequestDto request);

    public Member createAdmin(MemberSignUpRequestDto request);

}

package com.dongne.its.member.service;

import com.dongne.its.base.apiPayload.code.status.ErrorStatus;
import com.dongne.its.base.apiPayload.exception.handler.GeneralExceptionHandler;
import com.dongne.its.member.converter.MemberConverter;
import com.dongne.its.member.domain.Member;
import com.dongne.its.member.repository.MemberRepository;
import com.dongne.its.member.domain.enums.Role;
import com.dongne.its.member.web.dto.MemberDeleteRequestDto;
import com.dongne.its.member.web.dto.MemberRoleUpdateRequestDto;
import com.dongne.its.member.web.dto.MemberSignInRequestDto;
import com.dongne.its.member.web.dto.MemberSignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    @Override
    public void checkRole(Member member, Role role) {
        if (member.getRole() != role)
            throw new GeneralExceptionHandler(ErrorStatus.PERMISSION_DENY);
    }

    @Override
    public void checkPermissoion(Member member, Role role) {
        if(member.getRole().ordinal() < role.ordinal())
            throw new GeneralExceptionHandler(ErrorStatus.PERMISSION_DENY);
    }

    @Override
    public Member updateRole(MemberRoleUpdateRequestDto request) {
        Member member = memberRepository.findById(request.getId()).orElseThrow();
        member.setRole(Role.valueOf(request.getRole()));
        return memberRepository.save(member);
    }

    @Override
    public Member delete(MemberDeleteRequestDto request) {
        Member member = memberRepository.findById(request.getId()).orElseThrow();
        member.setDeleted(true);
        return memberRepository.save(member);
    }

    @Override
    public Member signUp(MemberSignUpRequestDto request) {
        Member member = MemberConverter.toMember(request);
        return memberRepository.save(member);
    }

    @Override
    public Member signIn(MemberSignInRequestDto request) {
        Member member = memberRepository.findMemberBySignId(request.getSignId()).orElseThrow();
        if (member.getPassword().equals(request.getPassword())) {
            System.out.println("Sign In Success");
            return member;
        }
        else{
            throw new GeneralExceptionHandler(ErrorStatus._BAD_REQUEST);
        }
    }

    @Override
    public Member createAdmin(MemberSignUpRequestDto request) {
        Member member = MemberConverter.toMember(request);
        member.setRole(Role.ADMIN);
        return memberRepository.save(member);
    }
}

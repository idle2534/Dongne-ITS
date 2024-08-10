package com.dongne.its.member.converter;

import com.dongne.its.member.domain.Member;
import com.dongne.its.member.service.enums.Role;
import com.dongne.its.member.web.dto.MemberResponseDto;
import com.dongne.its.member.web.dto.MemberSignUpRequestDto;

import java.util.List;

public class MemberConverter {

    public static MemberResponseDto toMemberResponseDto(Member member){
        return MemberResponseDto.builder()
                .id(member.getId())
                .role(String.valueOf(member.getRole()))
                .name(member.getName())
                .signId(member.getSignId())
                .isDeleted(member.isDeleted())
                .build();
    }
    public static List<MemberResponseDto> toListMemberResponseDto(List<Member> members){
        return members.stream().map(member -> MemberResponseDto.builder()
                .id(member.getId())
                .role(String.valueOf(member.getRole()))
                .name(member.getName())
                .signId(member.getSignId())
                .isDeleted(member.isDeleted())
                .build()).toList();
    }


    public static Member toMember(MemberSignUpRequestDto request) {
        return Member.builder()
                .signId(request.getSignId())
                .password(request.getPassword())
                .name(request.getName())
                .role(Role.valueOf(request.getRole()))
                .isDeleted(false)
                .build();
    }

    public static Member toMember(MemberResponseDto request) {
        return Member.builder()
                .id(request.getId())
                .name(request.getName())
                .role(Role.valueOf(request.getRole()))
                .isDeleted(request.getIsDeleted())
                .build();
    }
}

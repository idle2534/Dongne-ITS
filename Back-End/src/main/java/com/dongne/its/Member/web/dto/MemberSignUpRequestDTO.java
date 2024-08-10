package com.dongne.its.member.web.dto;

import lombok.Getter;

@Getter
public class MemberSignUpRequestDto {
    String signId;
    String password;
    String name;
    String role;
}

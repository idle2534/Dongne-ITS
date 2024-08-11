package com.dongne.its.member.web.dto;

import lombok.Getter;

@Getter
public class MemberSignUpRequestDto {
    private String signId;
    private String password;
    private String name;
    private String role;
}

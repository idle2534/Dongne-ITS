package com.dongne.its.Member.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignUpRequestDTO {
    private Long id;
    private String name;
    private String password;
    private String role;
}

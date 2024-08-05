package com.dongne.its.Member.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignInRequestDTO {
    private Long id;
    private String password;
}

package com.dongne.its.Member.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberReasonDTO implements MemberBaseCode {
    private String message;
    private String code;
    private boolean isSuccess;
    private HttpStatus httpStatus;

    @Override
    public MemberReasonDTO getReason() {
        return null;
    }

    @Override
    public MemberReasonDTO getReasonHttpStatus() {
        return null;
    }
}

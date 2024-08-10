package com.dongne.its.member.apiPayload.exception;

import com.dongne.its.member.apiPayload.code.MemberBaseErrorCode;
import com.dongne.its.member.apiPayload.code.MemberErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private MemberBaseErrorCode code;

    public MemberErrorReasonDto getErrorReason() {
        return this.code.getReason();
    }

    public MemberErrorReasonDto getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}

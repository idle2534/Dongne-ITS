package com.dongne.its.Member.apiPayload.code.status;

import com.dongne.its.Member.apiPayload.code.MemberBaseCode;
import com.dongne.its.Member.apiPayload.code.MemberReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberSuccessStatus implements MemberBaseCode {
    // 가장 일반적인 응답
    _OK(HttpStatus.OK, "COMMON200", "성공"),
    _CREATED(HttpStatus.CREATED, "COMMON201", "새로운 리소스 생성");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public MemberReasonDTO getReason() {
        return MemberReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public MemberReasonDTO getReasonHttpStatus() {
        return MemberReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}

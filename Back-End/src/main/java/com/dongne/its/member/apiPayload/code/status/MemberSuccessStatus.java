package com.dongne.its.member.apiPayload.code.status;

import com.dongne.its.member.apiPayload.code.MemberBaseCode;
import com.dongne.its.member.apiPayload.code.MemberReasonDto;
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
    public MemberReasonDto getReason() {
        return MemberReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public MemberReasonDto getReasonHttpStatus() {
        return MemberReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}

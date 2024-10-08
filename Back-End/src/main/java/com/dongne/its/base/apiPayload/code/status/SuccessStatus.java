package com.dongne.its.base.apiPayload.code.status;

import com.dongne.its.base.apiPayload.code.BaseCode;
import com.dongne.its.base.apiPayload.code.ReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    // 가장 일반적인 응답
    _OK(HttpStatus.OK, 200, "성공"),
    _CREATED(HttpStatus.CREATED, 201, "새로운 리소스 생성");

    private final HttpStatus httpStatus;
    private final Integer code;
    private final String message;

    @Override
    public ReasonDto getReason() {
        return ReasonDto.builder()
                .message(message)
                .code(code)
                .build();
    }

    @Override
    public ReasonDto getReasonHttpStatus() {
        return ReasonDto.builder()
                .message(message)
                .code(code)
                .httpStatus(httpStatus)
                .build();
    }
}

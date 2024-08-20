package com.dongne.its.base.apiPayload.code.status;

import com.dongne.its.base.apiPayload.code.BaseErrorCode;
import com.dongne.its.base.apiPayload.code.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // Common Error
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,400,"잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,401,"인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, 403, "금지된 요청입니다."),

    // Member Error
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, 4001, "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, 4002, "닉네임은 필수 입니다."),
    PERMISSION_DENY(HttpStatus.BAD_REQUEST, 4003, "권한이 없습니다."),

    // Project Error

    // Issue Error
    CATEGORY_NOT_MATCH(HttpStatus.BAD_REQUEST,4004,"검색 카테고리가 올바르지 않습니다.")

    // Comment Error

;
    private final HttpStatus httpStatus;
    private final Integer code;
    private final String message;

    @Override
    public ErrorReasonDto getReason() {
        return ErrorReasonDto.builder()
                .code(code)
                .message(message)
                .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus() {
        return ErrorReasonDto.builder()
                .message(message)
                .code(code)
                .httpStatus(httpStatus)
                .build();
    }
}

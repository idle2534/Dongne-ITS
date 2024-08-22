package com.dongne.its.base.apiPayload.code;

import com.dongne.its.base.apiPayload.exception.ConstraintExceptionDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@AllArgsConstructor
@JsonPropertyOrder({"code", "message", "timestamp", "data"})
public class ApiResponse<T> {
    private final Integer code;
    private final String message;
    private final String timestamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    // 성공한 경우 응답 생성
    public static <T> ResponseEntity<T> onSuccess(T result){
        return ResponseEntity.ok(result);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T data){
        return new ApiResponse<>(code.getReasonHttpStatus().getCode(), code.getReasonHttpStatus().getMessage(), GeneralTimestamp.getTimestamp(), data);
    }

    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(BaseErrorCode code, T data){
        return new ApiResponse<>(code.getReasonHttpStatus().getCode(), code.getReasonHttpStatus().getMessage(), GeneralTimestamp.getTimestamp(), data);
    }

    public static <T> ConstraintExceptionDto<T> onException(Integer code, String message, T data){
        return new ConstraintExceptionDto<>(code, message, GeneralTimestamp.getTimestamp(), data);
    }


}

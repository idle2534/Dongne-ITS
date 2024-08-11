package com.dongne.its.base.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseTemplate<T> {
    private Integer code;
    private String message;
    private String timestamp;
    private T data;
}

package com.dongne.its.base.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReasonDto {
    private Integer code;
    private String message;
    private HttpStatus httpStatus;
}

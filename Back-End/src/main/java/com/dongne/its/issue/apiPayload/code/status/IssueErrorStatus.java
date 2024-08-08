package com.dongne.its.issue.apiPayload.code.status;

import com.dongne.its.issue.apiPayload.code.IssueBaseErrorCode;
import com.dongne.its.issue.apiPayload.code.IssueErrorReasonDto;
import com.dongne.its.issue.web.dto.IssueResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum IssueErrorStatus implements IssueBaseErrorCode {

  // 가장 일반적인 응답
  _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
  _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
  _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
  _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),
  ;

  private final HttpStatus httpStatus;
  private final String code;
  private final String message;

  @Override
  public IssueErrorReasonDto getReason() {
    return IssueErrorReasonDto.builder()
        .message(message)
        .code(code)
        .isSuccess(false)
        .httpstatus(httpStatus)
        .build()
        ;
  }

  @Override
  public IssueResponseDto getReasonHttpStatus() {
    return null;
  }
}

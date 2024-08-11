package com.dongne.its.issue.apiPayload.code.status;

import com.dongne.its.issue.apiPayload.code.IssueBaseErrorCode;
import com.dongne.its.issue.apiPayload.code.IssueErrorReasonDto;
<<<<<<< HEAD
=======
import com.dongne.its.issue.web.dto.IssueResponseDto;
>>>>>>> 9ace679e12894bb5f386cd28c28d9ad87ca67487
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
<<<<<<< HEAD

  // 멤버 관려 에러
  MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
  NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

  // 예시,,,
  ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다.");
=======
  ;
>>>>>>> 9ace679e12894bb5f386cd28c28d9ad87ca67487

  private final HttpStatus httpStatus;
  private final String code;
  private final String message;

<<<<<<< HEAD
  //이유만 받는다
=======
>>>>>>> 9ace679e12894bb5f386cd28c28d9ad87ca67487
  @Override
  public IssueErrorReasonDto getReason() {
    return IssueErrorReasonDto.builder()
        .message(message)
        .code(code)
        .isSuccess(false)
<<<<<<< HEAD
=======
        .httpstatus(httpStatus)
>>>>>>> 9ace679e12894bb5f386cd28c28d9ad87ca67487
        .build()
        ;
  }

<<<<<<< HEAD
  //이유, httpStatus 모두 받는다
  @Override
  public IssueErrorReasonDto getReasonHttpStatus() {
    return IssueErrorReasonDto.builder()
        .message(message)
        .code(code)
        .isSuccess(false)
        .httpStatus(httpStatus)
        .build()
        ;
=======
  @Override
  public IssueResponseDto getReasonHttpStatus() {
    return null;
>>>>>>> 9ace679e12894bb5f386cd28c28d9ad87ca67487
  }
}

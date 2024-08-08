//package com.dongne.its.issue.apiPayload.code.status;
//
//import com.dongne.its.issue.apiPayload.code.IssueBaseSuccessCode;
//import com.dongne.its.issue.apiPayload.code.IssueSuccessReasonDTO;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import org.springframework.http.HttpStatus;
//
//@Getter
//@AllArgsConstructor
//public enum IssueSuccessStatus implements IssueBaseSuccessCode {
//
//  // 가장 일반적인 응답
//  _OK(HttpStatus.OK, "COMMON200", "성공"),
//  _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
//  _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
//  _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
//  _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),
//  ;
//
//  private final HttpStatus httpStatus;
//  private final String code;
//  private final String message;
//
//  @Override
//  public IssueSuccessReasonDTO getReason() {
//    return IssueSuccessReasonDTO.builder()
//        .message(message)
//        .code(code)
//        .isSuccess(false)
//        .httpstatus(httpStatus)
//        .build()
//        ;
//  }
//
//  @Override
//  public IssueSuccessReasonDTO getReasonHttpStatus() {
//    return null;
//  }
//}

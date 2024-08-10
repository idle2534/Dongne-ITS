package com.dongne.its.issue.apiPayload.exception;

import com.dongne.its.issue.apiPayload.code.IssueBaseErrorCode;
import com.dongne.its.issue.apiPayload.code.IssueErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IssueGeneralException extends RuntimeException {

  private IssueBaseErrorCode code;

  public IssueErrorReasonDto getErrorReason() {
    return this.code.getReason();
  }

  public IssueErrorReasonDto getErrorReasonHttpStatus(){
    return this.code.getReasonHttpStatus();
  }
}

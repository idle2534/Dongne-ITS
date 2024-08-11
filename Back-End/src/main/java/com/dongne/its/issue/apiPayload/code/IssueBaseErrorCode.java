package com.dongne.its.issue.apiPayload.code;


import com.dongne.its.issue.web.dto.IssueResponseDto;


public interface IssueBaseErrorCode {

  public IssueErrorReasonDto getReason();

  public IssueErrorReasonDto getReasonHttpStatus();

}

package com.dongne.its.issue.apiPayload.exception.handler;

import com.dongne.its.issue.apiPayload.code.IssueBaseErrorCode;
import com.dongne.its.issue.apiPayload.exception.IssueGeneralException;

public class IssueHandler extends IssueGeneralException {
  public IssueHandler (IssueBaseErrorCode errorCode){
    super(errorCode);
  }
}

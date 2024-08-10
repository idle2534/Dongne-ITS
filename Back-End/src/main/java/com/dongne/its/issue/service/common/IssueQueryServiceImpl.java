package com.dongne.its.issue.service.common;

import com.dongne.its.issue.apiPayload.code.status.IssueErrorStatus;
import com.dongne.its.issue.apiPayload.exception.handler.IssueHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IssueQueryServiceImpl implements IssueQueryService{

  @Override
  public void CheckFlag(Integer flag) {
      if (flag == 1)
        throw new IssueHandler(IssueErrorStatus._INTERNAL_SERVER_ERROR);
    }
}

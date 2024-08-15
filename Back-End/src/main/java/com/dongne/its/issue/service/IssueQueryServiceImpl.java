package com.dongne.its.issue.service;

import com.dongne.its.issue.apiPayload.code.status.IssueErrorStatus;
import com.dongne.its.issue.apiPayload.exception.handler.IssueHandler;
import com.dongne.its.issue.domain.Issue;
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

  @Override
  public Issue findIssueByIssueId(Long id) {
    return null;
  }

  @Override
  public Issue findIssueByProjectId(Long id) {
    return null;
  }

  @Override
  public Issue findTesterByProjectId(Long id) {
    return null;
  }

  @Override
  public Issue findDevByProjectId(Long id) {
    return null;
  }

  @Override
  public Issue search(Long id, String category, Long projectId, String keyword) {
    return null;
  }

  @Override
  public Issue recommend(Long id, Long issueId) {
    return null;
  }

  @Override
  public Issue deleteFind(Long id) {
    return null;
  }

  @Override
  public Issue all(Long id) {
    return null;
  }
}

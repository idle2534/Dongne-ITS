package com.dongne.its.issue.service;

import com.dongne.its.issue.domain.Issue;
import com.dongne.its.issue.web.dto.IssueAssignRequestDto;
import com.dongne.its.issue.web.dto.IssueCreateRequestDto;
import com.dongne.its.issue.web.dto.IssueDeleteRequestDto;
import com.dongne.its.issue.web.dto.IssueStatusUpdateRequestDto;
import com.dongne.its.issue.web.dto.IssueUpdateRequestDto;

public interface IssueCommandService {

  void CheckFlag(Integer flag);

  public Issue updateIssue(IssueUpdateRequestDto request);

  public Issue updateIssueDev(IssueStatusUpdateRequestDto request);

  public Issue reassign(IssueAssignRequestDto request);

  public Issue deleteRequest(IssueDeleteRequestDto request);

  public Issue delete(IssueDeleteRequestDto request);

  public Issue assign(IssueAssignRequestDto request);

  public Issue create(IssueCreateRequestDto request);


}

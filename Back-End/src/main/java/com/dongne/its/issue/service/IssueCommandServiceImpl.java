package com.dongne.its.issue.service;

import com.dongne.its.issue.domain.Issue;
import com.dongne.its.issue.domain.enums.Priority;
import com.dongne.its.issue.domain.enums.Status;
import com.dongne.its.issue.repository.IssueRepository;
import com.dongne.its.issue.web.dto.IssueAssignRequestDto;
import com.dongne.its.issue.web.dto.IssueCreateRequestDto;
import com.dongne.its.issue.web.dto.IssueDeleteRequestDto;
import com.dongne.its.issue.web.dto.IssueStatusUpdateRequestDto;
import com.dongne.its.issue.web.dto.IssueUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IssueCommandServiceImpl implements IssueCommandService{

  private final IssueRepository issueRepository;

  @Override
  public void CheckFlag(Integer flag) {

  }

  @Override
  public Issue updateIssue(IssueUpdateRequestDto request) {
    Issue issue = issueRepository.findById(request.getIssueId()).orElseThrow();
    issue.setDescription(request.getDescription());
    issue.setStatus(Status.valueOf(request.getStatus()));
    issue.setPriority(Priority.valueOf(request.getPriority()));
    issue.setCategory(request.getCategory());
    return issueRepository.save(issue);
  }

  @Override
  public Issue updateIssueDev(IssueStatusUpdateRequestDto request) {
    Issue issue = issueRepository.findById(request.getIssueId()).orElseThrow();
    issue.setStatus(Status.valueOf(request.getStatus()));
    return issueRepository.save(issue);
  }

  @Override
  public Issue reassign(IssueAssignRequestDto request) {
    Issue issue = issueRepository.findById(request.getIssueId()).orElseThrow();
    issue.setAssignee(issueRepository.findById(request.getAssigneeId()).orElseThrow().getAssignee());
    return issueRepository.save(issue);
  }

  @Override
  public Issue deleteRequest(IssueDeleteRequestDto request) {
    Issue issue = issueRepository.findById(request.getIssueId()).orElseThrow();
    issue.setDeleted(true);
    return issueRepository.save(issue);
  }

  @Override
  public Issue delete(IssueDeleteRequestDto request) {
    Issue issue = issueRepository.findById(request.getIssueId()).orElseThrow();
    issue.setDeleted(true);
    return issueRepository.save(issue);
  }

  @Override
  public Issue assign(IssueAssignRequestDto request) {

    return null;
  }

  @Override
  public Issue create(IssueCreateRequestDto request) {
    Issue issue = Issue.builder()
            .title(request.getTitle())
            .description(request.getDescription())
            .projectId(request.getProjectId())
            .category(request.getCategory())
            .build();
    return issueRepository.save(issue);
  }
}

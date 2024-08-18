package com.dongne.its.issue.service;

import com.dongne.its.issue.converter.IssueConverter;
import com.dongne.its.issue.domain.Issue;
import com.dongne.its.issue.domain.enums.Priority;
import com.dongne.its.issue.domain.enums.Status;
import com.dongne.its.issue.repository.IssueRepository;
import com.dongne.its.issue.web.dto.IssueAssignRequestDto;
import com.dongne.its.issue.web.dto.IssueCreateRequestDto;
import com.dongne.its.issue.web.dto.IssueDeleteRequestDto;
import com.dongne.its.issue.web.dto.IssueStatusUpdateRequestDto;
import com.dongne.its.issue.web.dto.IssueUpdateRequestDto;
import com.dongne.its.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IssueCommandServiceImpl implements IssueCommandService{

  private final IssueRepository issueRepository;
  private final MemberRepository memberRepository;

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
    issue.setAssignee(memberRepository.findById(request.getAssigneeId()).orElseThrow());
    return issueRepository.save(issue);
  }

  @Override
  public Issue deleteRequest(IssueDeleteRequestDto request) {
    Issue issue = issueRepository.findById(request.getIssueId()).orElseThrow();
    issue.setStatus(Status.DELETE_REQUEST);
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
    Issue issue = issueRepository.findById(request.getIssueId()).orElseThrow();
    issue.setAssignee(memberRepository.findById(request.getAssigneeId()).orElseThrow());
    return issueRepository.save(issue);
  }

  @Override
  public Issue create(Long id, IssueCreateRequestDto request) {
    Issue issue = IssueConverter.toIssue(request);
    issue.setStatus(Status.NEW);
    issue.setReporter(memberRepository.findById(id).orElseThrow());
    return issueRepository.save(issue);
  }
}

package com.dongne.its.issue.service;

import com.dongne.its.base.apiPayload.code.BaseErrorCode;
import com.dongne.its.base.apiPayload.code.status.ErrorStatus;
import com.dongne.its.base.apiPayload.exception.handler.GeneralExceptionHandler;
import com.dongne.its.issue.apiPayload.code.status.IssueErrorStatus;
import com.dongne.its.issue.apiPayload.exception.handler.IssueHandler;
import com.dongne.its.issue.domain.Issue;
import com.dongne.its.issue.domain.enums.Priority;
import com.dongne.its.issue.domain.enums.Status;
import com.dongne.its.issue.repository.IssueRepository;
import com.dongne.its.issue.web.dto.IssueRecommendResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueQueryServiceImpl implements IssueQueryService{

  private final IssueRepository issueRepository;

  @Override
  public void CheckFlag(Integer flag) {
      if (flag == 1)
        throw new IssueHandler(IssueErrorStatus._INTERNAL_SERVER_ERROR);
    }

  @Override
  public Issue findIssueById(Long id) {
    return issueRepository.findIssueById(id).orElseThrow();
  }

  @Override
  public List<Issue> findIssueByProjectId(Long id) {
    return issueRepository.findIssueByProjectId(id);
  }

  @Override
  public List<Issue> findTesterByProjectId(Long id) {
    return issueRepository.findTesterByProjectId(id);
  }

  @Override
  public List<Issue> findDevByProjectId(Long id) {
    return issueRepository.findDevByProjectId(id);
  }

  @Override
  public List<Issue> search(String category, Long projectId, String keyword) {
    switch(category){
      case "TITLE":
        return issueRepository.titleSearch(projectId, keyword);
      case "STATUS":
        return issueRepository.statusSearch(projectId, Status.valueOf(keyword));
      case "PRIORITY":
        return issueRepository.prioritySearch(projectId, Priority.valueOf(keyword));
      case "ASSIGNEE":
        return issueRepository.assigneeSearch(projectId, keyword);
      default:
        throw new GeneralExceptionHandler(ErrorStatus.CATEGORY_NOT_MATCH);

    }
  }

  @Override
  public List<IssueRecommendResponseDto> recommend(Long issueId) {
    List<Issue> issues = issueRepository.recommend(issueId);
    //

    List<IssueRecommendResponseDto> top3Score = null;
    return top3Score;
  }

  @Override
  public List<Issue> deleteFind() {
    return issueRepository.deleteFind();
  }

  @Override
  public List<Issue> all() {
    return issueRepository.all();
  }
}

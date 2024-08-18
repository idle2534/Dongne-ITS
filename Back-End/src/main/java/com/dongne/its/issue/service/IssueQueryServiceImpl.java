package com.dongne.its.issue.service;

import com.dongne.its.issue.apiPayload.code.status.IssueErrorStatus;
import com.dongne.its.issue.apiPayload.exception.handler.IssueHandler;
import com.dongne.its.issue.domain.Issue;
import com.dongne.its.issue.repository.IssueRepository;
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
    return null;
    //return issueRepository.findIssueByProjectId(id);
  }

  @Override
  public List<Issue> findTesterByProjectId(Long id) {
    return null;
    //return issueRepository.findTesterByProjectId(id);
  }

  @Override
  public List<Issue> findDevByProjectId(Long id) {
    return null;
    //return issueRepository.findDevByProjectId(id);
  }

  @Override
  public List<Issue> search(Long id, String category, Long projectId, String keyword) {
    return null;
    //return issueRepository.search(id, category, projectId, keyword);
  }

  @Override
  public List<Issue> recommend(Long id, Long issueId) {
    return null;
    //return issueRepository.recommend(id, issueId);
  }

  @Override
  public List<Issue> deleteFind(Long id) {
    return null;
    //return issueRepository.deleteFind(id);
  }

  @Override
  public List<Issue> all(Long id) {
    return null;
    //return issueRepository.all(id);
  }
}

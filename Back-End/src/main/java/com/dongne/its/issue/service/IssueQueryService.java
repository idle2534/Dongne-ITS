package com.dongne.its.issue.service;

import com.dongne.its.issue.domain.Issue;

import com.dongne.its.issue.web.dto.IssueRecommendResponseDto;
import java.util.List;

public interface IssueQueryService {

  void CheckFlag(Integer flag);

  Issue findIssueById(Long id);

  List<Issue> findIssueByProjectId(Long id);

  List<Issue> findTesterByProjectId(Long id);

  List<Issue> findDevByProjectId(Long id);

  List<Issue> search(String category, Long projectId, String keyword);

  List<IssueRecommendResponseDto> recommend(Long issueId);

  List<Issue> deleteFind();

  List<Issue> all();
}
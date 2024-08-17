package com.dongne.its.issue.service;

import com.dongne.its.issue.domain.Issue;

public interface IssueQueryService {

  void CheckFlag(Integer flag);

  Issue findIssueById(Long id);

  Issue findIssueByProjectId(Long id);

  Issue findTesterByProjectId(Long id);

  Issue findDevByProjectId(Long id);

  Issue search(Long id, String category, Long projectId, String keyword);

  Issue recommend(Long id, Long issueId);

  Issue deleteFind(Long id);

  Issue all(Long id);
}
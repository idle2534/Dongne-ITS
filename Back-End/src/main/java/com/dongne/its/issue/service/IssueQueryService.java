package com.dongne.its.issue.service;

import com.dongne.its.issue.domain.Issue;

import java.util.List;

public interface IssueQueryService {

  void CheckFlag(Integer flag);

  Issue findIssueById(Long id);

  List<Issue> findIssueByProjectId(Long id);

  List<Issue> findTesterByProjectId(Long id);

  List<Issue> findDevByProjectId(Long id);

  List<Issue> search(Long id, String category, Long projectId, String keyword);

  List<Issue> recommend(Long id, Long issueId);

  List<Issue> deleteFind(Long id);

  List<Issue> all(Long id);
}
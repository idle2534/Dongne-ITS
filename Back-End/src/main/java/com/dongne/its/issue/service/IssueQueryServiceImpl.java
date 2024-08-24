package com.dongne.its.issue.service;

import com.dongne.its.base.apiPayload.code.status.ErrorStatus;
import com.dongne.its.base.apiPayload.exception.handler.GeneralExceptionHandler;
import com.dongne.its.issue.converter.IssueConverter;
import com.dongne.its.issue.domain.Issue;
import com.dongne.its.issue.domain.enums.Priority;
import com.dongne.its.issue.domain.enums.Status;
import com.dongne.its.issue.repository.IssueRepository;
import com.dongne.its.issue.web.dto.IssueRecommendResponseDto;
import com.dongne.its.member.domain.Member;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueQueryServiceImpl implements IssueQueryService{

  private final IssueRepository issueRepository;

  @Override
  public Issue findIssueById(Long id) {
    return issueRepository.findIssueById(id).orElseThrow();
  }

  @Override
  public List<Issue> findIssueByProjectId(Long id) {
    return issueRepository.findIssueByProjectId(id);
  }

  @Override
  public List<Issue> findTesterByProjectId(Long id, Long projectId) {
    return issueRepository.findTesterByProjectId(id, projectId);
  }

  @Override
  public List<Issue> findDevByProjectId(Long id, Long projectId) {
    return issueRepository.findDevByProjectId(id, projectId);
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
    //이슈 받아오기
    List<Issue> issues_recommend = issueRepository.recommend(issueId);
    Issue issue_target = issueRepository.findIssueById(issueId).orElseThrow();
    Long projectId = issue_target.getProject().getId();

    List<Member> members = new ArrayList<>();
    List<Issue> issues = new ArrayList<>();
    List<Long> scores = new ArrayList<>();

    //이슈 반복문을 돌면서 중복되지 않는 개발자가 발견될 때 마다 IssueResponseDto, score=0을 레커맨드응답 dto 리스트에 넣는다
    for (Issue issue : issues_recommend) {
      if (issue.getAssignee() != null && !issue.getAssignee().getIsDeleted() && !members.contains(issue.getAssignee())){
        issues.add(issue);
        members.add(issue.getAssignee());
      }
    }

    for (Member member : members) {
      long solve = member.getFixIssues().stream().filter(issue -> issue.getProject().getId().equals(projectId)).count();
      long assign = member.getAssignIssues().stream().filter(issue -> issue.getProject().getId().equals(projectId)).count();
      long category = member.getAssignIssues().stream().filter(issue -> issue.getCategory() != null && issue.getCategory().equals(issue_target.getCategory())).count();
      scores.add(solve + assign + category);
    }

    return IssueConverter.toIssueRecommendResponseDtoList(issues, scores);
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

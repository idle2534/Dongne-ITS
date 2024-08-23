package com.dongne.its.issue.service;

import static com.dongne.its.issue.converter.IssueConverter.toIssueRecommendResponseDto;
import static com.dongne.its.issue.converter.IssueConverter.toIssueResponseDto;

import com.dongne.its.base.apiPayload.code.BaseErrorCode;
import com.dongne.its.base.apiPayload.code.status.ErrorStatus;
import com.dongne.its.base.apiPayload.exception.handler.GeneralExceptionHandler;
import com.dongne.its.base.converter.ProjectMemberConverter;
import com.dongne.its.issue.apiPayload.code.status.IssueErrorStatus;
import com.dongne.its.issue.apiPayload.exception.handler.IssueHandler;
import com.dongne.its.issue.converter.IssueConverter;
import com.dongne.its.issue.domain.Issue;
import com.dongne.its.issue.domain.enums.Priority;
import com.dongne.its.issue.domain.enums.Status;
import com.dongne.its.issue.repository.IssueRepository;
import com.dongne.its.issue.web.dto.IssueRecommendResponseDto;
import com.dongne.its.member.domain.Member;
import com.dongne.its.member.repository.MemberRepository;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueQueryServiceImpl implements IssueQueryService{

  private final IssueRepository issueRepository;
  private final MemberRepository memberRepository;

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
    //반환용 리스트 생성
    List<IssueRecommendResponseDto> top3Score = new ArrayList<>();
    int insertTrigger = 0;
    //이슈 받아오기
    List<Issue> issues = issueRepository.recommend(issueId);
    //이슈 반복문을 돌면서 중복되지 않는 개발자가 발견될 때 마다 IssueResponseDto, score=0을 레커맨드응답 dto 리스트에 넣는다
    List<Member> members = ProjectMemberConverter.toMembers(issues.get(0).getProject().getProjectMembers());
    top3Score.add(toIssueRecommendResponseDto(toIssueResponseDto(issues.get(0)), 0L));
    for(int i = 0; i<issues.size(); i++){
      insertTrigger = 0;
      for(int j = 0; j<top3Score.size(); j++){
        if(issues.get(i).getAssignee().getId().equals(top3Score.get(j).getIssueResponseDto().getAssignee().getId())
        && !issues.get(i).getAssignee().getIsDeleted()){
          insertTrigger = 1;
          break;
        }
      }
      if(insertTrigger != 1){
        top3Score.add(toIssueRecommendResponseDto(toIssueResponseDto(issues.get(i)),0L ));
      }
    }
    //score를 제외하고 완성된 리스트를 돌며 점수를 산정한다
    for(int  i = 0; i<top3Score.size(); i++){
      Long solveCount = 0L;
      Long assignCount = 0L;
      Long categoryCount = 0L;
      Member tempMember = memberRepository.findMemberById(top3Score.get(i).getIssueResponseDto().getAssignee().getId()).orElseThrow();

      List<Issue> tempIssues = tempMember.getFixIssues();
      for(int j = 0; j<tempIssues.size(); j++){
        if(tempIssues.get(j).getProject().getId().equals(top3Score.get(i).getIssueResponseDto().getProjectId())){
          solveCount++;
        }
      }

      tempIssues = tempMember.getAssignIssues();
      for(int j = 0; j<tempIssues.size(); j++){
        if(tempIssues.get(j).getAssignee().getId().equals(top3Score.get(i).getIssueResponseDto().getAssignee().getId())){
          assignCount++;
        }
      }

      for(int j = 0; j<issues.size(); j++){
        if(issueRepository.findIssueById(issueId).orElseThrow().getCategory().equals(issues.get(j).getCategory())){
          for(int k = 0; k<top3Score.size(); k++){
            if(top3Score.get(k).getIssueResponseDto().getAssignee().getId().equals(issues.get(j).getAssignee().getId())){
              categoryCount++;
            }
          }
        }
      }
      top3Score.get(i).setScore(solveCount + assignCount + categoryCount);
    }
    //리스트를 반환한다
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

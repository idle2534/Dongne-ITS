package com.dongne.its.issue.repository;

import com.dongne.its.issue.domain.Issue;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

  @Query("select i from Issue i where i.id = :id and i.isDeleted = false ")
  public Optional<Issue> findIssueById(@Param("id") Long id);

  @Query("select i from Issue i where i.projectId = :projectId and i.isDeleted = false")
  public List<Issue> findIssueByProjectId(@Param("projectId") Long projectId);

//  특정 프로젝트의 테스터가 담당하는 이슈들을 반환한다
  @Query("select i from Issue i, Project p, i.projectId pi "
      + "where p.id = pi and  pi = :projectId "
      + "and i.reporter in elements(p.projectMemberList) and i.isDeleted = false ")
  public List<Issue> findTesterByProjectId(@Param("projectId") Long projectId);

  @Query("select i from Issue i, Project p, i.projectId pi "
      + "where p.id = pi and pi = :projectId "
      + "and i.assignee in elements(p.projectMemberList) and i.isDeleted = false ")
  public List<Issue> findDevByProjectId(@Param("projectId") Long projectId);

  @Query("select i from Issue i, Project p where p.id = :projectId and i.projectId = p.id "
      + "and i.description like %:keyword% and i.isDeleted = false")
  public List<Issue> search(@Param("category") String category, @Param("projectId") Long projectId, @Param("keyword") String keyword);

//  @Query("")
//  public List<Issue> recommend(@Param("issueId") Long issueId);

  @Query("select i from Issue i where i.status = 'DELETE_REQUEST'")
  public List<Issue> deleteFind();

  @Query("select i from Issue i")
  public  List<Issue> all();
}

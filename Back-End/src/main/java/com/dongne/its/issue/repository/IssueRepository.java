package com.dongne.its.issue.repository;

import com.dongne.its.issue.domain.Issue;
import com.dongne.its.issue.domain.enums.Priority;
import com.dongne.its.issue.domain.enums.Status;
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

  @Query("select i from Issue i where i.project.id = :projectId and i.isDeleted = false")
  public List<Issue> findIssueByProjectId(@Param("projectId") Long projectId);

  //특정 프로젝트의 테스터가 담당하는 이슈들을 반환한다
  @Query("select i from Issue i where i.project.id = :projectId and i.reporter.id = :id and i.isDeleted = false")
  public List<Issue> findTesterByProjectId(@Param("id") Long id, @Param("projectId") Long projectId);

  @Query("select i from Issue i where i.project.id = :projectId and (i.reporter.id = :id or i.fixer.id = :id or i.assignee.id = :id)  and i.isDeleted = false")
  public List<Issue> findDevByProjectId(@Param("id") Long id, @Param("projectId") Long projectId);

  @Query("select i from Issue i, Project p where p.id = :projectId and i.project.id = p.id "
      + "and i.title like %:keyword% and i.isDeleted = false")
  public List<Issue> titleSearch(@Param("projectId") Long projectId, @Param("keyword") String keyword);

  @Query("select i from Issue i, Project p where p.id = :projectId and i.project.id = p.id "
      + "and i.status = :keyword and i.isDeleted = false")
  public List<Issue> statusSearch(@Param("projectId") Long projectId, @Param("keyword") Status keyword);

  @Query("select i from Issue i, Project p where p.id = :projectId and i.project.id = p.id "
      + "and i.priority = :keyword and i.isDeleted = false")
  public List<Issue> prioritySearch(@Param("projectId") Long projectId, @Param("keyword") Priority keyword);

  @Query("select i from Issue i, Project p where p.id = :projectId and i.project.id = p.id "
      + "and i.assignee.name like %:keyword% and i.isDeleted = false")
  public List<Issue> assigneeSearch(@Param("projectId") Long projectId, @Param("keyword") String keyword);

  @Query("select i from Issue i "
      + "where i.project = (select iss.project from Issue iss where iss.id = :issueId) "
      + "and i.isDeleted = false")
  public List<Issue> recommend(@Param("issueId") Long issueId);

  @Query("select i from Issue i where i.status = 'DELETE_REQUEST'")
  public List<Issue> deleteFind();

  @Query("select i from Issue i where i.isDeleted = false")
  public  List<Issue> all();
}

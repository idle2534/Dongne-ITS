package com.dongne.its.issue.domain;

import com.dongne.its.issue.domain.common.BaseEntity;
import com.dongne.its.issue.domain.enums.Priority;
import com.dongne.its.issue.domain.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Issue extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50)
  private String title;

  @Column(length = 1000)
  private String description;

  @Column(columnDefinition = "VARCHAR(20)")
  @Enumerated(EnumType.STRING)
  private Priority priority;

  @Column(columnDefinition = "VARCHAR(20)")
  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(columnDefinition = "DATETIME(6)")
  private LocalDateTime reportedDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reporterId")
  private Member reporter;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fixerId")
  private Member fixer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "assigneeId")
  private Member assignee;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "projectId")
  private Project project;

  @Column(length = 50)
  private String category;

  @Column()
  private boolean isDeleted;
}

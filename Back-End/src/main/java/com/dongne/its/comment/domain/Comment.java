package com.dongne.its.comment.domain;

import com.dongne.its.base.domain.common.BaseEntity;
import com.dongne.its.issue.domain.Issue;
import com.dongne.its.member.domain.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Comment extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 1000)
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "writer")
  private Member writer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "issue_id")
  private Issue issue;

  private Boolean isDeleted;
}

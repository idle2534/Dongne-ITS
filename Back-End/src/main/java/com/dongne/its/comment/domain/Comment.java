package com.dongne.its.comment.domain;

import com.dongne.its.issue.domain.Issue;
import jakarta.persistence.*;

@Entity
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Issue issue;

  private String content;

  // Default constructor for JPA
  protected Comment() {
  }

  // Constructor to initialize fields
  public Comment(Issue issue, String content) {
    this.issue = issue;
    this.content = content;
  }

  // Getters
  public Long getId() {
    return id;
  }

  public Issue getIssue() {
    return issue;
  }

  public String getContent() {
    return content;
  }
}

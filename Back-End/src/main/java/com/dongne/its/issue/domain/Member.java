package com.dongne.its.issue.domain;

import com.dongne.its.issue.domain.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50)
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "VARCHAR(20)")
  private Role role;

  @Column(length = 50)
  private String name;

  @Column()
  private boolean isDeleted;
}
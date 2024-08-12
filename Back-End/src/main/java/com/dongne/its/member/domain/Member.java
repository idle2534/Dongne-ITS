package com.dongne.its.member.domain;


import com.dongne.its.base.domain.common.BaseEntity;
import com.dongne.its.member.domain.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sign_id")
    private String signId;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String name;
    private boolean isDeleted;
}

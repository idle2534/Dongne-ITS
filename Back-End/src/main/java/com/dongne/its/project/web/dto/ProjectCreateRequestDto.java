package com.dongne.its.project.web.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ProjectCreateRequestDto {
    private String name;
    private List<Long> memberIds;
}

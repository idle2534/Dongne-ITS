package com.dongne.its.issue.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IssueErrorReasonDto {
  private String message;
  private String code;
  private boolean isSuccess;

  private HttpStatus httpStatus;

}

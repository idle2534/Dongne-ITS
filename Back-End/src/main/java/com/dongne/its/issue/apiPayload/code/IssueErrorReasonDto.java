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
<<<<<<< HEAD
  private HttpStatus httpStatus;
=======
  private HttpStatus httpstatus;
>>>>>>> 9ace679e12894bb5f386cd28c28d9ad87ca67487

}

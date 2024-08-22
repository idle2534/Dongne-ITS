package com.dongne.its.issue.apiPayload.code;
//BaseCode를 받기 위함
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IssueReasonDto {
  private String message;
  private String code;
  private Boolean isSuccess;
  private HttpStatus httpstatus;

}

package com.dongne.its.issue.apiPayload;

import com.dongne.its.issue.apiPayload.code.IssueBaseCode;
import com.dongne.its.issue.apiPayload.code.status.IssueSuccessStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class IssueApiResponse<T> {

  @JsonProperty("isSuccess")
  private final Boolean isSuccess;
  private final String code;
  private final String message;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private T result;
    //성공
    public static <T> IssueApiResponse<T> onSuccess(T result){
        return new IssueApiResponse<>(true, IssueSuccessStatus._OK.getCode() , IssueSuccessStatus._OK.getMessage(), result);
    }

    public static <T> IssueApiResponse<T> of(IssueBaseCode code, T result){
          return new IssueApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
    }

    // 실패
    public static <T> IssueApiResponse<T> onFailure(String code, String message, T data){
      return new IssueApiResponse<>(true, code, message, data);
    }
}

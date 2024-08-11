package com.dongne.its.issue.apiPayload.exception;

import com.dongne.its.issue.apiPayload.IssueApiResponse;
import com.dongne.its.issue.apiPayload.code.IssueErrorReasonDto;
import com.dongne.its.issue.apiPayload.code.status.IssueErrorStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice(annotations = {RestController.class})
public class IssueExceptionAdvice extends ResponseEntityExceptionHandler {


  @org.springframework.web.bind.annotation.ExceptionHandler
  public ResponseEntity<Object> validation(ConstraintViolationException e, WebRequest request) {
    String errorMessage = e.getConstraintViolations().stream()
        .map(constraintViolation -> constraintViolation.getMessage())
        .findFirst()
        .orElseThrow(() -> new RuntimeException("ConstraintViolationException 추출 도중 에러 발생"));

    return handleExceptionInternalConstraint(e, IssueErrorStatus.valueOf(errorMessage), HttpHeaders.EMPTY,request);
  }


  @Override
  public ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

    Map<String, String> errors = new LinkedHashMap<>();

    e.getBindingResult().getFieldErrors().stream()
        .forEach(fieldError -> {
          String fieldName = fieldError.getField();
          String errorMessage = Optional.ofNullable(fieldError.getDefaultMessage()).orElse("");
          errors.merge(fieldName, errorMessage, (existingErrorMessage, newErrorMessage) -> existingErrorMessage + ", " + newErrorMessage);
        });

    return handleExceptionInternalArgs(e,HttpHeaders.EMPTY,IssueErrorStatus.valueOf("_BAD_REQUEST"),request,errors);
  }

  @org.springframework.web.bind.annotation.ExceptionHandler
  public ResponseEntity<Object> exception(Exception e, WebRequest request) {
    e.printStackTrace();

    return handleExceptionInternalFalse(e, IssueErrorStatus._INTERNAL_SERVER_ERROR, HttpHeaders.EMPTY, IssueErrorStatus._INTERNAL_SERVER_ERROR.getHttpStatus(),request, e.getMessage());
  }
  @ExceptionHandler(value = IssueGeneralException.class)
  public ResponseEntity onThrowException(IssueGeneralException generalException, HttpServletRequest request) {
    IssueErrorReasonDto errorReasonHttpStatus = generalException.getErrorReasonHttpStatus();
    return handleExceptionInternal(generalException,errorReasonHttpStatus,null,request);
  }

  private ResponseEntity<Object> handleExceptionInternal(Exception e, IssueErrorReasonDto reason,
      HttpHeaders headers, HttpServletRequest request) {

    IssueApiResponse<Object> body = IssueApiResponse.onFailure(reason.getCode(),reason.getMessage(),null);
//        e.printStackTrace();

    WebRequest webRequest = new ServletWebRequest(request);
    return super.handleExceptionInternal(
        e,
        body,
        headers,
        reason.getHttpStatus(),
        webRequest
    );
  }

  private ResponseEntity<Object> handleExceptionInternalFalse(Exception e, IssueErrorStatus errorCommonStatus,
      HttpHeaders headers, HttpStatus status, WebRequest request, String errorPoint) {
    IssueApiResponse<Object> body = IssueApiResponse.onFailure(errorCommonStatus.getCode(),errorCommonStatus.getMessage(),errorPoint);
    return super.handleExceptionInternal(
        e,
        body,
        headers,
        status,
        request
    );
  }

  private ResponseEntity<Object> handleExceptionInternalArgs(Exception e, HttpHeaders headers, IssueErrorStatus errorCommonStatus,
      WebRequest request, Map<String, String> errorArgs) {
    IssueApiResponse<Object> body = IssueApiResponse.onFailure(errorCommonStatus.getCode(),errorCommonStatus.getMessage(),errorArgs);
    return super.handleExceptionInternal(
        e,
        body,
        headers,
        errorCommonStatus.getHttpStatus(),
        request
    );
  }

  private ResponseEntity<Object> handleExceptionInternalConstraint(Exception e, IssueErrorStatus errorCommonStatus,
      HttpHeaders headers, WebRequest request) {
    IssueApiResponse<Object> body = IssueApiResponse.onFailure(errorCommonStatus.getCode(), errorCommonStatus.getMessage(), null);
    return super.handleExceptionInternal(
        e,
        body,
        headers,
        errorCommonStatus.getHttpStatus(),
        request
    );
  }
}
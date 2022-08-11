package com.alphacode.handson.web.apis.v1.handler;

import com.alphacode.handson.web.apis.v1.ResponseCode;
import com.alphacode.handson.web.apis.v1.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    var fieldErrors = ex.getBindingResult().getFieldErrors();
    var objectErrors = ex.getBindingResult().getGlobalErrors();
    var errors = new HashMap<String, Object>();

    for (FieldError error : fieldErrors) {
      errors.put(error.getField(), error.getDefaultMessage());
    }

    for (ObjectError error : objectErrors) {
      errors.put(error.getObjectName(), error.getDefaultMessage());
    }

    return new ResponseEntity<>(makeError(ResponseCode.BAD_REQUEST.name(), "잘못된 요청 입니다.", errors), headers, status);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Object> handleResourceNotFountException(ResourceNotFoundException ex) {
    var error = makeError(ex.getCode(), ex.getMessage(), ex.getErrors());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }


  private Map<String, Object> makeError(String code, String message, Map<String, Object> errors)
  {
    Map<String, Object> error = new HashMap<>(Map.of(
            "timestamp", new Date(),
            "code", code.toUpperCase(),
            "message", message
    ));

    if (errors != null) {
      error.put("errors", errors);
    }

    return error;
  }
}

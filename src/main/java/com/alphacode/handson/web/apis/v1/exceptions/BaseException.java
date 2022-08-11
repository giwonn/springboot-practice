package com.alphacode.handson.web.apis.v1.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class BaseException extends RuntimeException {
  private final String code;
  private final Map<String, Object> errors;

  public BaseException(String message, String code, Map<String, Object> errors) {
    super(message);
    this.code = code;
    this.errors = errors;
  }
}

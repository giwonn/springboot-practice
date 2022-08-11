package com.alphacode.handson.web.apis.v1.exceptions;

import com.alphacode.handson.web.apis.v1.ResponseCode;

import java.util.Collections;
import java.util.Map;

public class ResourceNotFoundException extends BaseException {
  public ResourceNotFoundException() {
    this("리소스를 찾을 수 없습니다.");
  }

  public ResourceNotFoundException(String message) {
    this(message, ResponseCode.NOT_FOUND.name(), Collections.emptyMap());
  }

  public ResourceNotFoundException(String message, String code, Map<String, Object> errors) {
    super(message, code, errors);
  }

}

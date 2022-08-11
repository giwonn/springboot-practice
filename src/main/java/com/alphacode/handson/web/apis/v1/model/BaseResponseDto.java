package com.alphacode.handson.web.apis.v1.model;

import lombok.Getter;

import java.util.Collections;
import java.util.Date;

@Getter
public abstract class BaseResponseDto {

  private final String code;
  private final String message;

  private final Long timestamp = new Date().toInstant().toEpochMilli();

  public BaseResponseDto(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public BaseResponseDto() {
    this.code = "OK";
    this.message = "Done";
  }

  public abstract Object getData();

  public static BaseResponseDto empty() {
    return new BaseResponseDto() {
      @Override
      public Object getData() {
        return Collections.emptyMap();
      }
    };
  }

}

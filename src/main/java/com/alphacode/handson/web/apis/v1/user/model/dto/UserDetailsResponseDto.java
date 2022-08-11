package com.alphacode.handson.web.apis.v1.user.model.dto;

import com.alphacode.handson.web.apis.v1.model.BaseResponseDto;
import com.alphacode.handson.web.apis.v1.user.model.User;

public class UserDetailsResponseDto extends BaseResponseDto {

  private final User user;

  public UserDetailsResponseDto(User user) {
    this.user = user;
  }

  @Override
  public Object getData() {
    return this.user;
  }

  public static UserDetailsResponseDto of(User user) {
    return new UserDetailsResponseDto(user);
  }
}

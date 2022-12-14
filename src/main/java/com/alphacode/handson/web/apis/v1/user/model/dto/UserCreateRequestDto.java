package com.alphacode.handson.web.apis.v1.user.model.dto;

import com.alphacode.handson.web.apis.v1.user.model.User;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class UserCreateRequestDto {

  @NotBlank
  private String username;

  @Email
  @NotBlank
  private String email;

  private String firstName;

  private String lastName;

  public User to() {
    return User.builder()
            .username(this.username)
            .email(this.email)
            .firstName(this.firstName)
            .lastName(this.lastName)
            .build();
  }
}

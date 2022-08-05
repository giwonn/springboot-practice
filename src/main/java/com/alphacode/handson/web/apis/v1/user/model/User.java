package com.alphacode.handson.web.apis.v1.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.utility.RandomString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User {

  @Id
  private String id = "USR-" + RandomString.make(30);

  private String username;

  private String email;

  private String firstName;

  private String lastName;

  private String profileImageUrl;

  private String state;

  private Long latestLoggedInAt;

  private Long latestPasswordChangedAt;

  private Long createAd = new Date().toInstant().getEpochSecond();

  private Long updatedAt;

  @Builder
  public User(String username, String email, String firstName, String lastName) {
    this.username = username;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}

package com.alphacode.handson.web.apis.v1.user.service;

import com.alphacode.handson.web.apis.v1.exceptions.ResourceNotFoundException;
import com.alphacode.handson.web.apis.v1.user.model.User;
import com.alphacode.handson.web.apis.v1.user.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public List<User> list() {
    return repository.findAll();
  }

  public User save(User user) {
    return repository.save(user);
  }

  @SneakyThrows
  public User details(String id) {
    return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
  }
  public void emailUpdate(String id, String email) {
    var user = this.details(id);
    user.setEmail(email);
    user.setUpdatedAt(new Date().toInstant().toEpochMilli());
    this.save(user);
  }
  public void delete(String id) {
    repository.deleteById(id);
  }

}

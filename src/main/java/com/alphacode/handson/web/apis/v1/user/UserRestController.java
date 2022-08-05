package com.alphacode.handson.web.apis.v1.user;

import com.alphacode.handson.web.apis.v1.user.model.User;
import com.alphacode.handson.web.apis.v1.user.model.dto.UserEmailUpdateDto;
import com.alphacode.handson.web.apis.v1.user.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.alphacode.handson.web.apis.v1.user.model.dto.UserCreateDto;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserRestController {

  private final UserService service;

  public UserRestController(UserService service) {
    this.service = service;
  }

  @GetMapping
  public List<User> list() {
    return service.list();
  }

  @PostMapping
  public User create(@RequestBody UserCreateDto dto) {
    return service.save(dto.to());
  }

  @GetMapping("/{id}")
  public User details(@PathVariable("id") String id) {
    return service.details(id);
  }

  @PatchMapping("/{id}/email")
  public void updateEmail(@PathVariable("id") String id, @RequestBody UserEmailUpdateDto dto) {
    service.emailUpdate(id, dto.getEmail());
  }

  @DeleteMapping("/{id}/email")
  public void deleteEmail(@PathVariable("id") String id) {
    this.details(id);
    service.delete(id);
  }

}


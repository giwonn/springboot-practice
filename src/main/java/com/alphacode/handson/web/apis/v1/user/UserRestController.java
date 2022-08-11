package com.alphacode.handson.web.apis.v1.user;

import com.alphacode.handson.web.apis.v1.user.model.User;
import com.alphacode.handson.web.apis.v1.user.model.dto.UserDetailsResponseDto;
import com.alphacode.handson.web.apis.v1.user.model.dto.UserEmailUpdateDto;
import com.alphacode.handson.web.apis.v1.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.alphacode.handson.web.apis.v1.user.model.dto.UserCreateRequestDto;

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
  public User create(@RequestBody @Validated UserCreateRequestDto dto, BindingResult bindingResult) throws BindException {

    if (bindingResult.hasErrors()) {
      throw new BindException(bindingResult);
    }
    return service.save(dto.to());
  }

  @ResponseBody
  @GetMapping("/{id}")
  public ResponseEntity<UserDetailsResponseDto> details(@PathVariable("id") String id) {
    User user = service.details(id);
    return ResponseEntity.ok(UserDetailsResponseDto.of(user));
  }

  @PatchMapping("/{id}/email")
  public void updateEmail(@PathVariable("id") String id, @RequestBody UserEmailUpdateDto dto) {
    service.emailUpdate(id, dto.getEmail());
  }

  @DeleteMapping("/{id}")
  public void deleteEmail(@PathVariable("id") String id) {
    service.delete(id);
  }

}


package auditions.logique.urlshortener.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auditions.logique.urlshortener.entities.User;
import auditions.logique.urlshortener.services.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
  private final UserService service;

  @GetMapping
  public List<User> getAllUsers() {
    return this.service.getAllUsers();
  }
}

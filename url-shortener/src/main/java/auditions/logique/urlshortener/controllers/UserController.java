package auditions.logique.urlshortener.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auditions.logique.urlshortener.dto.CreateUserDTO;
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

  @PostMapping
  public User createUser(@RequestBody CreateUserDTO dto) {
    return this.service.create(dto);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    this.service.delete(id);
    return;
  }
}

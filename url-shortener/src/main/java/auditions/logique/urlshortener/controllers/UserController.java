package auditions.logique.urlshortener.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auditions.logique.urlshortener.dto.AuthDTO;
import auditions.logique.urlshortener.dto.CreateUserDTO;
import auditions.logique.urlshortener.entities.User;
import auditions.logique.urlshortener.services.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
  private final UserService service;

  @GetMapping
  public List<User> getAllUsers() {
    return this.service.getAllUsers();
  }

  @PostMapping("/signin")
  public ResponseEntity<User> signin(@RequestBody AuthDTO dto) {
    return new ResponseEntity<>(this.service.signIn(dto), HttpStatus.OK);
  }

  @PostMapping("/signup")
  public ResponseEntity<User> createUser(@RequestBody CreateUserDTO dto) {
    return new ResponseEntity<>(this.service.create(dto), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    this.service.delete(id);
    return;
  }
}

package auditions.logique.urlshortener.controllers;

import java.time.Duration;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
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
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class UserController {
  private final UserService service;

  @GetMapping
  public List<User> getAllUsers() {
    return this.service.getAllUsers();
  }

  @PostMapping("/signin")
  public ResponseEntity<String> signin(@RequestBody AuthDTO dto, HttpServletResponse response) {
    var user = this.service.signIn(dto);

    var cookie = ResponseCookie
        .from("user-id", user.get_id())
        .httpOnly(true)
        .secure(true)
        // .maxAge((3600 * 24))
        .maxAge(60)
        .path("/url")
        .domain("localhost")
        .build();

    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(cookie.toString());
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

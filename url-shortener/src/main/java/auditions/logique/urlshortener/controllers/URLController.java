package auditions.logique.urlshortener.controllers;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

import auditions.logique.urlshortener.dto.CreateURLDTO;
import auditions.logique.urlshortener.services.URLService;
import auditions.logique.urlshortener.viewmodels.URLViewModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/url")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class URLController {
  private final URLService service;

  @GetMapping("")
  public Stream<URLViewModel> findAll(@CookieValue(name = "user-id") String userID) {
    return this.service.listAll(userID);
  }

  @PostMapping("")
  public URLViewModel create(@CookieValue(name = "user-id") String userID, @RequestBody CreateURLDTO dto) {
    return this.service.create(dto, userID);
  }
}

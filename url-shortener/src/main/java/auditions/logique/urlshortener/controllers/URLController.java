package auditions.logique.urlshortener.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auditions.logique.urlshortener.dto.CreateURLDTO;
import auditions.logique.urlshortener.entities.URL;
import auditions.logique.urlshortener.services.URLService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/url")
@CrossOrigin("*")
public class URLController {
  private final URLService service;

  @GetMapping("/{userID}")
  public List<URL> findAll(@PathVariable String userID) {
    return this.service.listAll(userID);
  }

  @PostMapping("/{userID}")
  public URL create(@PathVariable String userID, @RequestBody CreateURLDTO dto) {
    return this.service.create(dto, userID);
  }
}

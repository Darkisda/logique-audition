package auditions.logique.urlshortener.services;

import java.util.List;

import org.springframework.stereotype.Service;

import auditions.logique.urlshortener.entities.User;
import auditions.logique.urlshortener.repositories.UserRepository;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class UserService {
  private final UserRepository repository;

  public List<User> getAllUsers() {
    return this.repository.findAll();
  }
}

package auditions.logique.urlshortener.services;

import java.util.List;

import org.springframework.stereotype.Service;

import auditions.logique.urlshortener.dto.CreateUserDTO;
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

  public User create(CreateUserDTO dto) {
    var user = new User();
    user.setEmail(dto.getEmail());
    user.setPassword(dto.getPassword());

    return this.repository.save(user);
  }

  public void delete(String id) {
    this.repository.deleteById(id);
    return;
  }
}

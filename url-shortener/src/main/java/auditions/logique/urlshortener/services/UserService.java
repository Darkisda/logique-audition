package auditions.logique.urlshortener.services;

import java.text.DateFormat;
import java.time.Duration;
import java.util.List;

import org.springframework.boot.web.server.Cookie;
import org.springframework.stereotype.Service;

import auditions.logique.urlshortener.dto.AuthDTO;
import auditions.logique.urlshortener.dto.CreateUserDTO;
import auditions.logique.urlshortener.entities.User;
import auditions.logique.urlshortener.errors.AlreadyExistUser;
import auditions.logique.urlshortener.errors.NotFoundUser;
import auditions.logique.urlshortener.errors.UnauthorizedLogin;
import auditions.logique.urlshortener.repositories.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
  private final UserRepository repository;

  public List<User> getAllUsers() {
    return this.repository.findAll();
  }

  public User findById(String id) {
    var user = this.repository.findById(id);

    if (!user.isPresent()) {
      throw new NotFoundUser();
    }

    return user.get();
  }

  public User signIn(AuthDTO dto) {
    var user = this.repository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());

    if (user == null) {
      throw new UnauthorizedLogin();
    }

    return user;
  }

  public User create(CreateUserDTO dto) {
    var alreadyExistUser = this.repository.findByEmail(dto.getEmail());

    if (alreadyExistUser != null) {
      throw new AlreadyExistUser();
    }

    var user = new User();
    user.setEmail(dto.getEmail());
    user.setPassword(dto.getPassword());

    return this.repository.save(user);
  }

  public void delete(String id) {
    var userWhoShouldMayBeDeleted = this.repository.findById(id);

    if (userWhoShouldMayBeDeleted == null) {
      throw new NotFoundUser();
    }

    this.repository.deleteById(id);
    return;
  }
}

package auditions.logique.urlshortener.services;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import auditions.logique.urlshortener.dto.CreateURLDTO;
import auditions.logique.urlshortener.entities.URL;
import auditions.logique.urlshortener.repositories.URLRepository;
import auditions.logique.urlshortener.viewmodels.URLViewModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class URLService {
  private final URLRepository repository;
  private final UserService userService;

  public Stream<URLViewModel> listAll(String userId) {
    var user = this.userService.findById(userId);

    var result = this.repository
        .findByUserId(userId)
        .stream()
        .map(url -> new URLViewModel(url));

    return result;
  }

  public URLViewModel create(CreateURLDTO dto, String userId) {
    var entity = new URL();

    entity.setOriginURL(dto.getOriginURL());
    entity.setBaseUrl(dto.getBaseURL());
    entity.setUser_id(userId);

    entity.setHashURL(this.handleGenerationShortURL());

    var url = this.repository.save(entity);

    return new URLViewModel(url);
  }

  public String handleGenerationShortURL() {
    String encoded = "";
    var base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    for (var i = 0; i < 10; i++) {
      var randomChar = (int) Math.floor(Math.random() * base.length);
      encoded += base[randomChar];
    }

    return encoded;
  }
}

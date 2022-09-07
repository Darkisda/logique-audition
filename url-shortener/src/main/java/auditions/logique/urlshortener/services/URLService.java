package auditions.logique.urlshortener.services;

import java.util.List;

import org.springframework.stereotype.Service;

import auditions.logique.urlshortener.dto.CreateURLDTO;
import auditions.logique.urlshortener.entities.URL;
import auditions.logique.urlshortener.repositories.URLRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class URLService {
  private final URLRepository repository;

  public List<URL> listAll(String userId) {
    return this.repository.findByUserId(userId);
  }

  public URL create(CreateURLDTO dto, String userId) {
    var entity = new URL();

    entity.setOriginURL(dto.getOriginURL());
    entity.setUser_id(userId);
    entity.setHashURL(this.handleGenerationShortURL());

    var url = this.repository.save(entity);

    return url;
  }

  public String handleGenerationShortURL() {
    String encoded = "";
    var base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    for (var i = 0; i < 10; i ++) {
      var randomChar = ( int ) Math.floor(Math.random() * base.length);
      encoded += base[randomChar];
    }

    return encoded;
  }
}

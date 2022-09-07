package auditions.logique.urlshortener.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import auditions.logique.urlshortener.entities.URL;

public interface URLRepository extends MongoRepository<URL, String> {
  @Query(value = "{ 'user_id' : ?0 }")
  List<URL> findByUserId(String user_id);
}

package auditions.logique.urlshortener.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import auditions.logique.urlshortener.entities.URL;

public interface URLRepository extends MongoRepository<URL, String> {
  
}

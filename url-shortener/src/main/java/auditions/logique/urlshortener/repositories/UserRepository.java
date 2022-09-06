package auditions.logique.urlshortener.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import auditions.logique.urlshortener.entities.User;

public interface UserRepository extends MongoRepository<User, String> {
  User findByEmailAndPassword(String email, String password);
}

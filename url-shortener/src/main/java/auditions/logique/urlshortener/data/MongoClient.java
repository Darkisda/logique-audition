package auditions.logique.urlshortener.data;

import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.stereotype.Component;

@Component
public class MongoClient {
  private final MongoDatabaseFactory mongo;

  public MongoClient(MongoDatabaseFactory mongo) {
    this.mongo = mongo;
  }
}

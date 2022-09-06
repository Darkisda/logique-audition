package auditions.logique.urlshortener.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class User {
  @Id
  private String _id;
  
  @Indexed(unique = true)
  private String email;
  private String password;
}

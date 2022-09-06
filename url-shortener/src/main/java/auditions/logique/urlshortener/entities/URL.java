package auditions.logique.urlshortener.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class URL {
  @Id
  private String _id;

  private String hashURL;
  private String originURL;

  private String user_id;
}

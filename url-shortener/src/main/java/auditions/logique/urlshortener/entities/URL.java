package auditions.logique.urlshortener.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class URL {
  @Id
  private String _id;

  private String baseUrl;
  private String hashURL;
  private String originURL;

  private String user_id;
  @CreatedDate
  private Date created_at;
}

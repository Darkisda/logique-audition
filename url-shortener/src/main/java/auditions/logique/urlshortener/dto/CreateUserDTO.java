package auditions.logique.urlshortener.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateUserDTO {
  private String email;
  private String password;
}

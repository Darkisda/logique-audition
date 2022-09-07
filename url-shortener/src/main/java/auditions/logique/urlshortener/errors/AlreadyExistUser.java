package auditions.logique.urlshortener.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyExistUser extends RuntimeException {
  public AlreadyExistUser() {
    super("Endereço de email já está em uso");
  }
}

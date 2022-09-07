package auditions.logique.urlshortener.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundUser extends RuntimeException {
  public NotFoundUser() {
    super("Usuário não encontrado");
  }
}

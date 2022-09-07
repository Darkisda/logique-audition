package auditions.logique.urlshortener.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedLogin extends RuntimeException {
  public UnauthorizedLogin() {
    super("Credênciais inválidas");
  }
}

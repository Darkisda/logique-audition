package auditions.logique.urlshortener.viewmodels;

import java.text.SimpleDateFormat;

import auditions.logique.urlshortener.entities.URL;
import lombok.Data;

@Data
public class URLViewModel {
  private String _id;

  private String originURL;
  private String generateURL;

  private String user_id;
  private String created_at;

  public URLViewModel(URL url) {
    this._id = url.get_id();
    this.originURL = url.getOriginURL();
    this.user_id = url.getUser_id();

    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    this.created_at = fmt.format(url.getCreated_at());

    this.generateURL = url.getBaseUrl() + url.getHashURL();
  }
}

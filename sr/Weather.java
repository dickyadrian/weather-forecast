import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weather {
  public static final String KEY = "9afd7ebe839abc36cf9461782c39cdeb";
  private String response;

  /**
   * Default constructor.
   *
   */
  public Weather() {
    String tmpStr;
    try {
      URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?q=bandung&appid=9afd7ebe839abc36cf9461782c39cdeb");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.setUseCaches(false);
      connection.setDoInput(true);
      connection.setDoOutput(false);
      connection.connect();

      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      while ((tmpStr = reader.readLine()) != null) {
        this.response = tmpStr;
      }
    } catch (IOException e) {
      this.response = "URL not found";
    }
  }

  public String getResponse() {
    return response;
  }

  public static void main(String[] args) {
    Weather test =  new Weather();
    System.out.println(test.getResponse());
  }
}

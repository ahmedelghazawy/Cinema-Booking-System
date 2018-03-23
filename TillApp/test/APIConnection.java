import java.net.*;

public class APIConnection{
  public void get() throws Exception{
    URL url = new URL ("127.0.0.1:8000/api/movieTimingsapi/1/2018-03-12");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    

    con.setRequestMethod("GET");
  }

  public static void main(String[] args) {

  }
}

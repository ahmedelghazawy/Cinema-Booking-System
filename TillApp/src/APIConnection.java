import java.net.*;
import java.io.*;

public class APIConnection{
  public static void get() throws Exception{
    URL url = new URL ("http://127.0.0.1:8000/api/movieTimingsapi/1/2018-03-12/?format=json");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();


    con.setRequestMethod("GET");
    con.setRequestProperty("User-Agent", "Mozilla/5.0");

    int responseCode = con.getResponseCode();
    System.out.println("response code = " + responseCode);

    BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
  }

  public static void main(String[] args) {
    try {

    APIConnection.get();
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
}

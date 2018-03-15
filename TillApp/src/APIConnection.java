import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.*;
import java.io.*;

public class APIConnection{
    public static void get() throws Exception
    {
        // URL url = new URL ("http://127.0.0.1:8000/api/movieTimingsapi/1/2018-03-15/?format=json");
        URL url = new URL ("http://127.0.0.1:8000/api/whatsonapi?format=json");
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

    public static void main(String[] args)
    {
        try
        {
            // APIConnection.get();
            // String json = "{\"id\":1,\"title\":\"The Greates Showman\",\"cover\":\"img/MovieCovers/TheGreatestShowman.jpg\",\"rating\":8.0,\"certificate\":\"0\",\"releaseDate\":\"2018-02-18\"}";
            String json = "{\"id\":1, \"title\": \"hello\"}";
            Gson gson = new Gson();
            Movie movie = gson.fromJson(json, Movie.class);
            // Movie movie = new Movie(3, "Hey There!");
            // System.out.println(movie.getTitle());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

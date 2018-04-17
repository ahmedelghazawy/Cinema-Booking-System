import org.codehaus.jackson.map.ObjectMapper;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.HttpsURLConnection;

public class APIConnection{

    public static String[] get(String link) throws Exception
    {
        URL url = new URL (link);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();


        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		    String inputLine;
        inputLine = in.readLine();
		    in.close();

        // Deleting the []
        inputLine = inputLine.replace("[","");
        inputLine = inputLine.replace("]","");

        // Separating the input by json objects, but also getting "," as a String
        String[] separated = inputLine.split("[{}]");
        // Getting the length of the separated array
        int sLength = separated.length;
        // Finding the length of the array of only json objects
        int jLength = sLength - (sLength/2);
        // Initialising the json objects array
        String[] jsons = new String[jLength];
        int j = 0;
        for (int i = 0; i < sLength; i++)
        {
            // Adding the json objects to its array
            if (!separated[i].equals(",") && !separated[i].equals(""))
            {
                String toAdd = "{";
                jsons[j] = toAdd;
                jsons[j] += separated[i];
                jsons[j] += "}";
                j++;
            }
        }
        return jsons;
    }

    public static void post(String link, String json) throws Exception{
      link = "http://127.0.0.1:8000/api/seatingapi/1/";
      json = "[{\"vipSeat\":true, \"screening_id\":1, \"row\":1, \"column\":1}]";
      URL url = new URL(link);
      HttpURLConnection con = (HttpURLConnection) url.openConnection();

      //request headers
      con.setRequestMethod("POST");
      con.setRequestProperty("User-Agent", "Mozilla/5.0");
      con.setRequestProperty("Accept", "application/json");
      con.setRequestProperty("Content-Type", "application/json");
      con.setRequestProperty("csrf-token", "v(*=jce0x!kw1vyw9jw+=31ya^_$!98t_*^0&pglnvh118_hjn");

      //send post request
      con.setDoOutput(true);
      DataOutputStream wr = new DataOutputStream(con.getOutputStream());
      wr.writeBytes(json);
      wr.flush();
      wr.close();

      int responseCode = con.getResponseCode();
      System.out.println("Post request going to " + link);
      System.out.println("Response code: " + responseCode);

      BufferedReader in = new BufferedReader(
              new InputStreamReader(con.getInputStream()));
      System.out.println("no exception");
      String inputLine;
      StringBuffer response = new StringBuffer();

      while((inputLine = in.readLine()) != null){
        response.append(inputLine);
      }
      in.close();

      //print result
      System.out.println("response \n" + response.toString());
    }

      public static void main(String[] args) {
        try{
          post(new String(), new String());
        }
        catch (Exception e){
          System.err.println("Exception thrown");
        }
      }
}

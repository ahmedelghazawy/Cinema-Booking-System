package src;
import org.codehaus.jackson.map.ObjectMapper;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.HttpsURLConnection;

/**
 * Class containing methods for requesting or posting information to the REST API
 */
public class APIConnection{

    /**
     * Method for getting the information from the API
     * @param link for knowing which link to take the information from
     * @return String[] containing all the json objects gotten from the API
     * @throws Exception in case Link is not found
     */
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

    /**
     * Method for posting information to the REST API
     * @param link for knowing which link to post the information to
     * @param json the json string which is to be posted in the API
     * @return int informing whether the post request was successful or not
     * @throws Exception
     */
    public static int post(String link, String json) throws Exception{
      URL url = new URL(link);
      HttpURLConnection con = (HttpURLConnection) url.openConnection();

      //request headers
      con.setRequestMethod("POST");
      con.setRequestProperty("User-Agent", "Mozilla/5.0");
      con.setRequestProperty("Accept", "application/json");
      con.setRequestProperty("Content-Type", "application/json");

      //send post request
      con.setDoOutput(true);
      DataOutputStream wr = new DataOutputStream(con.getOutputStream());
      wr.writeBytes(json);
      wr.flush();
      wr.close();

      int responseCode = con.getResponseCode();
      if (responseCode > 199 && responseCode < 300){
          return 0;
      }
      else{
          return 1;
      }
    }
}

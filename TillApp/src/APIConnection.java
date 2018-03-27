import org.codehaus.jackson.map.ObjectMapper;
import java.net.*;
import java.io.*;
import java.util.*;

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
}

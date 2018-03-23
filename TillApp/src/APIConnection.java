import org.codehaus.jackson.map.ObjectMapper;
import java.net.*;
import java.io.*;
import java.util.*;

public class APIConnection{

    public static String[] get() throws Exception
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
        inputLine = in.readLine();
		in.close();

        // deleting the []
        inputLine = inputLine.replace("[","");
        inputLine = inputLine.replace("]","");

		//print result
		//System.out.println(inputLine);

        String[] separated = inputLine.split("[{}]");
        int sLength = separated.length;
        int jLength = sLength - (sLength/2);
        String[] jsons = new String[jLength];
        int j = 0;
        for (int i = 0; i < sLength; i++)
        {
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

    public static void main(String[] args)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            String[] jsons = APIConnection.get();
            ArrayList<Movie> movies = new ArrayList<>();
            for (int i = 0; i < jsons.length; i++)
            {
                System.out.println(jsons[i]);
                Movie movie = mapper.readValue(jsons[i], Movie.class);
                movies.add(movie);
            }
            System.out.println();
            System.out.println("=== From ArrayList ===");
            System.out.println();
            for (int j = 0; j < movies.size(); j++)
            {
                System.out.println(movies.get(j).getTitle());
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}


class Movie {
    private String title = "";
    private int id = 0;
    private String cover = "";
    private double rating = 0;
    private String releaseDate = "";
    private String certificate = "";

    public Movie(){}

    public Movie(int id, String title, String cover, double rating, String certificate, String releaseDate)
    {
        this.id = id;
        this.title = title;
    }

    public int geID() { return id;}

    public String getTitle() { return title; }

    public String getCover() { return cover; }

    public double getRating() { return rating; }

    public String getCertificate() { return certificate; }

    public String getReleaseDate() { return releaseDate; }

    public void setID(int id) { this.id = id; }

    public void setTitle(String title) { this.title = title; }

    public void setCover(String cover) { this.cover = cover; }

    public void setRating(double rating) { this.rating = rating; }

    public void setCertificate(String certificate) { this.certificate = certificate; }

    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

}

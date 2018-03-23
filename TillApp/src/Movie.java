import org.codehaus.jackson.map.ObjectMapper;
import java.util.*;
import java.net.*;
import java.io.*;

/**
 * Created by sc16tdad on 09/02/18.
 */
public class Movie {
    private String title;
    private int id;
    private String cover;
    private double rating;
    private String releaseDate;
    private String certificate;
    private List<Screening> screenings;

    public Movie()
    {
        title = "";
        id = 0;
        cover = "";
        rating = 0.0;
        releaseDate = "";
        certificate= "";
    }

    public Movie(int id, String title, String cover, double rating, String certificate, String releaseDate)
    {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.rating = rating;
        this.certificate = certificate;
        this.releaseDate = releaseDate;
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

    public static void getObjectsFromAPI()
    {
        try
        {
            // URL containing the API
            String url = "http://127.0.0.1:8000/api/whatsonapi?format=json";

            // Part of the Jackson library, creating a mapper to map the json object to the movie object
            ObjectMapper mapper = new ObjectMapper();
            String[] jsons = APIConnection.get(url);
            ArrayList<Movie> movies = new ArrayList<>();

            // Turning json object into Movie objects and storing these in the ArrayList created above
            for (int i = 0; i < jsons.length; i++)
            {
                System.out.println(jsons[i]); // for testing
                Movie movie = mapper.readValue(jsons[i], Movie.class);
                movies.add(movie);
            }

            System.out.println();
            System.out.println("=== From ArrayList ===");
            System.out.println();

            for (int j = 0; j < movies.size(); j++)
            {
                System.out.println(movies.get(j).getTitle()); // for testing
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

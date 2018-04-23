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
    private String blurb;
    private String cover;
    private double rating;
    private String releaseDate;
    private String certificate;
    private int duration;
    private String director;
    //private List<Integer> cast;
    private List<Screening> screenings;

    /**
     * Empty constructor for creating a movie with default values
     */
    public Movie()
    {
        title = "";
        id = 0;
        cover = "";
        rating = 0.0;
        releaseDate = "";
        certificate= "";
    }

    /**
     * Constructor for creating a specific movie
     * @param id Movie ID on the database/api
     * @param title Movie title to be shown
     * @param cover Path for cover images
     * @param rating Movie rating from viewers
     * @param certificate Certificate for viewing criteria
     * @param releaseDate Movie release date
     */
    public Movie(int id, String title, String cover, double rating, String certificate, String releaseDate)
    {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.rating = rating;
        this.certificate = certificate;
        this.releaseDate = releaseDate;
    }

    public int getID() { return id;}

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

    public void setBlurb(String blurb) { this.blurb = blurb;}

    public void setDuration(int duration) {this.duration = duration;}

    public void setDirector(String director) {this.director = director;}

    //public void setCast (List<Integer> cast) {this.cast = cast;}

    public boolean equals(Object other){
      if(this == other){
        return true;
      }
      else if(! (other instanceof Movie)){
        return false;
      }
      else{
        Movie otherMovie = (Movie) other;
        return this.id == otherMovie.getID()
                && this.title == otherMovie.getTitle()
                && this.cover == otherMovie.getCover()
                && this.rating == otherMovie.getRating()
                && this.certificate == otherMovie.getCertificate()
                && this.releaseDate == otherMovie.getReleaseDate();
      }

    }

    /**
     * Method for getting an ArrayList of movies for the movies contained within the database
     * @return ArrayList containing all movie being shown in the cinema
     */
    public static ArrayList<Movie> getMovies()
    {
        //ArrayList contain the movies being shown in the cinema
        ArrayList<Movie> movies = new ArrayList<>();
        try
        {
            // URL containing the API
            String url = "http://127.0.0.1:8000/api/whatsonapi?format=json";

            // Part of the Jackson library, creating a mapper to map the json object to the movie object
            ObjectMapper mapper = new ObjectMapper();
            String[] jsons = APIConnection.get(url);

            // Turning json object into Movie objects and storing these in the ArrayList created above
            for (String json: jsons)
            {
                Movie movie = mapper.readValue(json, Movie.class);
                movies.add(movie);
            }
            return movies;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return movies;
    }
}

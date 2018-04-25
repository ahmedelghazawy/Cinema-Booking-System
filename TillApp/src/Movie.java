package src;
import org.codehaus.jackson.map.ObjectMapper;
import java.util.*;
import java.net.*;
import java.io.*;
/**
 * Created by sc16tdad on 09/02/18.
 */
public class Movie {
    private int id;
    private String title;
    private String blurb;
    private double rating;
    private int duration;
    private String certificate;

    /**
     * Empty constructor for creating a movie with default values
     */
    public Movie()
    {
        id = 0;
        title = "";
        blurb = "";
        rating = 0.0;
        duration = 0;
        certificate= "";
    }

    /**
     * Constructor for creating a specific movie
     * @param id Movie ID on the database/api
     * @param title Movie title to be shown
     * @param blurb Movie story
     * @param rating Movie rating from viewers
     * @param duration Duration of the movie in minutes
     * @param certificate Movie viewing certificate
     */
    public Movie(int id, String title, String blurb, double rating, int duration, String certificate)
    {
        this.id = id;
        this.title = title;
        this.blurb = blurb;
        this.rating = rating;
        this.duration = duration;
        this.certificate = certificate;
    }

    public int getID() { return id;}

    public String getTitle() { return title; }

    public String getBlurb() { return blurb; }

    public double getRating() { return rating; }

    public int getDuration() { return duration; }

    public String getCertificate() { return certificate; }

    public void setID(int id) { this.id = id; }

    public void setTitle(String title) { this.title = title; }

    public void setBlurb(String blurb) { this.blurb = blurb; }

    public void setRating(double rating) { this.rating = rating; }

    public void setDuration(int duration) { this.duration = duration; }

    public void setCertificate(String certificate) { this.certificate = certificate; }

    @Override
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
                && this.blurb == otherMovie.getBlurb()
                && this.rating == otherMovie.getRating()
                && this.duration == otherMovie.getDuration()
                && this.certificate == otherMovie.getCertificate();
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

import org.codehaus.jackson.map.ObjectMapper;
import java.util.*;
import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;

/**
 * Created by sc16tdad on 09/02/18.
 */
public class Screening {

    private int id;
    private String date;
    private String time;
    private int movie_id;
    private int screen_id;

    /**
     * Empty constructor for default screening values
     */
    public Screening()
    {
        id = 0;
        date = "";
        time = "";
        movie_id = 0;
        screen_id = 0;
    }

    /**
     * Screening constructor for creating a screening with certain values
     * @param id Screening id for a movie
     * @param date Screening date
     * @param time Screening time
     * @param movie_id ID of movie showing
     * @param screen_id Screen ID showing the movie
     */
    public Screening(int id, String date, String time, int movie_id, int screen_id)
    {
        this.id = id;
        this.date = date;
        this.time = time;
        this.movie_id = movie_id;
        this.screen_id = screen_id;
    }

    public int getId() { return id;}

    public String getDate() { return date; }

    public String getTime() { return time; }

    public int getMovie_id() { return movie_id; }

    public int getScreen_id() { return screen_id; }

    public void setId() { this.id = id; }

    public void setDate() { this.date = date; }

    public void setTime() { this.time = time; }

    public void setMovie_id() { this.movie_id = movie_id; }

    public void setScreen_id() { this.screen_id = screen_id; }

    public int numberOfStandardSeats() {
        Screen screen = Screen.getScreen(this.id);
        return screen.getStandardSeats();
    }

    public int numberOfVipSeats() {
        Screen screen = Screen.getScreen(this.id);
        return screen.getVipSeats();
    }

    /**
     * Creates a get request to get the list of screenings for a specific movie for a specific day
     * @param movie Movie which it's screenings are required
     * @param daysToDate Number for how far away the date is
     * @return ArrayList of screenings for the specific movie on the specific day
     */
    public static ArrayList<Screening> getScreenings(Movie movie, int daysToDate)
    {
        //ArrayList containing screenings
        ArrayList<Screening> screenings = new ArrayList<>();
        try
        {
            //Acquiring date of screening
            Date date = new Date();
            if(daysToDate > 0){
              Calendar calendar = Calendar.getInstance();
              calendar.setTime(date);
              calendar.add(Calendar.DATE, daysToDate);
              date = calendar.getTime();
            }
            //formatting date to suite the URL format
            String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
            //URL for the API
            String url = "http://127.0.0.1:8000/api/movieTimingsapi/" + movie.getID() + "/" + formattedDate + "/?format=json";

            // Part of the Jackson library, creating a mapper to map the json object to the screening object
            ObjectMapper mapper = new ObjectMapper();
            String[] jsons = APIConnection.get(url);

            // Turning json object into Screening objects and storing these in the ArrayList created above
            for (String json: jsons)
            {
                Screening screening = mapper.readValue(json, Screening.class);
                screenings.add(screening);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return screenings;
    }
}

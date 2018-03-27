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

    public Screening()
    {
        id = 0;
        date = "";
        time = "";
        movie_id = 0;
        screen_id = 0;
    }

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

    public static ArrayList<Screening> getScreenings(Movie movie, int daysToDate)
    {
        ArrayList<Screening> screenings = new ArrayList<>();
        try
        {
            // URL containing the API
            Date date = new Date();
            if(daysToDate > 0){
              Calendar calendar = Calendar.getInstance();
              calendar.setTime(date);
              calendar.add(Calendar.DATE, 1);
              date = calendar.getTime();
            }
            String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String url = "http://127.0.0.1:8000/api/movieTimingsapi/" + movie.getID() + "/" + formattedDate + "/?format=json";

            // Part of the Jackson library, creating a mapper to map the json object to the screening object
            ObjectMapper mapper = new ObjectMapper();
            String[] jsons = APIConnection.get(url);

            // Turning json object into Screening objects and storing these in the ArrayList created above
            for (int i = 0; i < jsons.length; i++)
            {
                Screening screening = mapper.readValue(jsons[i], Screening.class);
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

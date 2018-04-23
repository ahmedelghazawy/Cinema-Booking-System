import org.codehaus.jackson.map.ObjectMapper;
import java.util.*;
import java.net.*;
import java.io.*;

/**
 * Created by sc16tdad on 09/02/18.
 */
public class Seat {
    private int id;
    private int screening_id;
    private boolean vipSeat;
    private int row;
    private int column;
    private boolean availability;

    public Seat(String type, String row, int column, boolean availability){}

    public int getScreening_id() { return screening_id; }

    public boolean getVipSeat() { return vipSeat; }

    public int getRow() { return row; }

    public int getColumn() { return column; }

    public boolean getAvailability() { return availability; }

    public void changeAvailability() {
        this.availability = false;
        String link = "http://127.0.0.1:8000/api/seatingapi/" + screening_id;

        String jsonSeat = "{\"vipSeat\":" + this.getVipSeat() + ", \"screening_id\":" + this.getScreening_id() + ", \"row\":" + this.getRow() + ", \"column\":" + this.getColumn() + "}";


        try{
          APIConnection.post(link,jsonSeat);
        }
        catch (Exception e){
          System.err.println("Exception thrown");
        }
    }

    public static List<Seat> getBookedSeats(int screeningID) {

        //ArrayList contain the movies being shown in the cinema
        ArrayList<Seat> seats = new ArrayList<>();
        try
        {
            // URL containing the API
            String url = "http://127.0.0.1:8000/api/seatingapi/" + screeningID;

            // Part of the Jackson library, creating a mapper to map the json object to the movie object
            ObjectMapper mapper = new ObjectMapper();
            String[] jsons = APIConnection.get(url);

            // Turning json object into Movie objects and storing these in the ArrayList created above
            for (String json: jsons)
            {
                Seat seat = mapper.readValue(json, Seat.class);
                seats.add(seat);
            }
            return seats;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return seats;
    }
}

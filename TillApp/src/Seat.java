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

    public Seat(){
        this.id = 0;
        this.screening_id = 0;
        this.vipSeat = false;
        this.row = 0;
        this.column = 0;
        this.availability = true;
    }

    public Seat(int id, int screening_id, boolean vipSeat, int row, int column, boolean availability){
        this.id = id;
        this.screening_id = screening_id;
        this.vipSeat = vipSeat;
        this.row = row;
        this.column = column;
        this.availability = availability;
    }

    public int getScreening_id() { return screening_id; }

    public boolean getVipSeat() { return vipSeat; }

    public int getRow() { return row; }

    public int getColumn() { return column; }

    public boolean getAvailability() { return availability; }

    public void setID(int id) { this.id = id; }

    public void setScreening_id(int screening_id) { this.screening_id = screening_id; }

    public void setVipSeat(boolean vipSeat) { this.vipSeat = vipSeat; }

    public void setRow(int row) { this.row = row; }

    public void setColumn(int column) { this.column = column; }

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

    public static ArrayList<Seat> getBookedSeats(int screeningID) {

        //ArrayList contain the movies being shown in the cinema
        ArrayList<Seat> seats = new ArrayList<>();
        try
        {
            // URL containing the API
            String url = "http://127.0.0.1:8000/api/seatingapi/" + screeningID + "/?format=json";

            // Part of the Jackson library, creating a mapper to map the json object to the movie object
            ObjectMapper mapper = new ObjectMapper();
            String[] jsons = APIConnection.get(url);

            // Turning json object into Movie objects and storing these in the ArrayList created above
            for (String json: jsons)
            {
                Seat seat = mapper.readValue(json, Seat.class);
                seat.availability = false;
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

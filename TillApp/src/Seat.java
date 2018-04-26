package src;
import org.codehaus.jackson.map.ObjectMapper;
import java.util.*;
import java.net.*;
import java.io.*;

/**
 * Created by sc16tdad on 09/02/18.
 * Class for accessing the Seat API, getting all the information needed and creating post requests
 */
public class Seat {
    private int id;
    private int screening_id;
    private boolean vipSeat;
    private int row;
    private int column;
    private boolean confirmed;

    /**
     * Empty constructor
     */
    public Seat(){
        this.id = 0;
        this.screening_id = 0;
        this.vipSeat = false;
        this.row = 0;
        this.column = 0;
        this.confirmed = true;
    }

    /**
     * Constructo
     * @param id Of the seat
     * @param screening_id Id of the screening we are getting the information for
     * @param vipSeat Whether this seat is vip or not
     * @param row of this seat
     * @param column of this seat
     * @param confirmed Whether it's available for booking or if it's already booked
     */
    public Seat(int id, int screening_id, boolean vipSeat, int row, int column, boolean confirmed){
        this.id = id;
        this.screening_id = screening_id;
        this.vipSeat = vipSeat;
        this.row = row;
        this.column = column;
        this.confirmed = confirmed;
    }

    public int getId() { return id; }

    public int getScreening_id() { return screening_id; }

    public boolean getVipSeat() { return vipSeat; }

    public int getRow() { return row; }

    public int getColumn() { return column; }

    public boolean getConfirmed() { return confirmed; }

    public void setID(int id) { this.id = id; }

    public void setScreening_id(int screening_id) { this.screening_id = screening_id; }

    public void setVipSeat(boolean vipSeat) { this.vipSeat = vipSeat; }

    public void setRow(int row) { this.row = row; }

    public void setColumn(int column) { this.column = column; }

    /**
     * Method changing the information from seat available to seat not available
     */
    public void changeconfirmed() {
        this.confirmed = false;
        String link = "http://127.0.0.1:8000/api/seatingapi/" + screening_id;

        String jsonSeat = "{\"vipSeat\":" + this.getVipSeat() + ", \"screening_id\":" + this.getScreening_id() + ", \"row\":" + this.getRow() + ", \"column\":" + this.getColumn() + "}";


        try{
          APIConnection.post(link,jsonSeat);
        }
        catch (Exception e){
          System.err.println("Exception thrown");
        }
    }

    /**
     * Method which checks which seats have been booked already or not
     * @param screeningID Id of the screening which this is being looked into
     * @return ArrayList<Seat> containing all seats which are booked
     */
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
                seat.confirmed = false;
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

    /**
     * Method for checking whether two Seat objects are equal
     * @param other second seat object to be compared to
     * @return boolean showing whether they are equal or not
     */
    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        else if(! (other instanceof Seat)){
            return false;
        }
        else{
            Seat otherSeat = (Seat) other;
            return this.id == otherSeat.getId()
                    && this.screening_id == otherSeat.getScreening_id()
                    && this.vipSeat == otherSeat.getVipSeat()
                    && this.row == otherSeat.getRow()
                    && this.column == otherSeat.getColumn()
                    && this.confirmed == otherSeat.getConfirmed();
        }

    }

    /**
     * Method for turning Seat into a string
     * @return String of the equivalent Seat object
     */
    @Override
    public String toString(){
        String number = "";
        number += "Row: " + this.getRow() + " Col: " + this.getColumn();
        return number;
    }
}

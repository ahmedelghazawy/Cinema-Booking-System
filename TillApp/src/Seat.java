/**
 * Created by sc16tdad on 09/02/18.
 */
public class Seat {
    private String seatNumber;
    private String type;
    private boolean availability;

    public Seat(String seatNumber, String type, boolean availability){}

    public void changeAvailability(){}

    public String getType() {
        return type;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}

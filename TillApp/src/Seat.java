/**
 * Created by sc16tdad on 09/02/18.
 */
public class Seat {
    private int screening_id;
    private boolean vipSeat;
    private int row;
    private int column;
    private boolean availability;

    public Seat(String type, String row, int column, boolean availability){}


    public int getRow() {
        return row;
    }

    public int getColumn() { return column; }

    public boolean getAvailability() { return availability; }

    public void changeAvailability(){ this.availability = !availability; }
}

/**
 * Created by sc16tdad on 09/02/18.
 */
package src;
public class Ticket {

    private Screening screening;
    private Seat seat;
    private float price;
    private String type;

    public Ticket(Screening screening, Seat seat, String type){
        this.screening = screening;
        this.seat = seat;
        this.type = type;
    }

    public void setPrice(float price) { this.price = price; }

    public void setScreening(Screening screening) { this.screening = screening; }

    public void setSeat(Seat seat) { this.seat = seat; }

    public void setType(String type) { this.type = type; }

    public float getPrice() { return price; }

    public Screening getScreening() { return screening; }

    public Seat getSeat() { return seat; }

    public String getType() { return type; }
}

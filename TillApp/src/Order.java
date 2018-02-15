/**
 * Created by sc16tdad on 09/02/18.
 */
import java.util.ArrayList;
import java.util.List;
public class Order {

    private List<Ticket> tickets;
    private float totalPrice;
    private float moneyPaid;
    private float change;

    public Order(){
        tickets = new ArrayList<>();
        totalPrice = 0;
        moneyPaid = 0;
        change = 0;
    }

    public void add(Ticket ticket){}

    public void offer(){}

    public void checkout(){}

    public void printTickets(){}
}

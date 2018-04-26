/**
 * Created by sc16tdad on 09/02/18.
 */
package src;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for combining all the Tickets, and finalising the total price for purchase
 */
public class Order {

    private List<Ticket> tickets;
    private float totalPrice;
    private float moneyPaid;
    private float change;

    /**
     * Empty constructor
     */
    public Order() {
        tickets = new ArrayList<>();
        totalPrice = 0;
        moneyPaid = 0;
        change = 0;
    }

    /**
     * Method for adding more tickets to the order
     * @param ticket The ticket to be added
     */
    public void add(Ticket ticket) {
        tickets.add(ticket);
        totalPrice += ticket.getPrice();
    }

    /**
     * Method for calculating the change to be given to the customer
     * @param money the amount given by the customer
     * @return float Being the change that needs to be given back by the employee
     */
    public float checkout(float money) {
        if (money < totalPrice) {
            return -1;
        }
        else {
            this.moneyPaid = money;
            change = moneyPaid - totalPrice;
            return change;
        }
    }

    /**
     * Method for printing the ticket as a PDF
     */
    public void printTickets(){}

    // Main class for testing if he API connection is work
    public static void main(String[] args)
    {
        System.out.println("======= MOVIEEEEE =======");
        ArrayList<Movie> movies = Movie.getMovies();
        for(Movie movie: movies){
          System.out.println("Movie name: " + movie.getTitle());
          System.out.println("Screenings:");
          ArrayList<Screening> screenings = Screening.getScreenings(movie, 1);
          for(Screening screening: screenings){
            System.out.println(screening.getTime());
            System.out.println("Standard Seats = " + screening.numberOfStandardSeats());
            System.out.println("VIP Seats = " + screening.numberOfVipSeats());
          }
        }
        ArrayList<Seat> bookedSeats = Seat.getBookedSeats(1);
        if(bookedSeats.isEmpty() == false){
          for(Seat seat: bookedSeats){
            System.out.println("Row " + seat.getRow());
            System.out.println("Column " + seat.getColumn());
            System.out.println("Screening ID " + seat.getScreening_id());
            System.out.println("VIP status is " + seat.getVipSeat());
          }
        }
        else{
            System.out.println("AL empty");
        }
    }
}

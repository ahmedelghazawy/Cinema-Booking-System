package src;
import org.codehaus.jackson.map.ObjectMapper;
import java.util.*;
import java.net.*;
import java.io.*;

public class Till {
    //fields for trying out the booking system requests and functionality
    private static ArrayList<Movie> whatsOn;
    private static ArrayList<Screening> screenings;
    private static ArrayList<Seat> bookedSeats;
    private static Movie chosenMovie = null;
    private static Screening chosenScreening = null;

    //main method for operating the till system
    public static void main(String[] args) {
        //clearing the console
        System.out.print("\033[H\033[2J");
        Scanner input = new Scanner(System.in);
        boolean active = true;

        //while loop operating till system
        while(active == true){

            System.out.println("Welcome to Cine-toucan, these are the movies we are viewing");
            whatsOn = Movie.getMovies();
            for(Movie movie: whatsOn){
                System.out.println(movie.getID() + ":" + movie.getTitle());
            }

            System.out.println("Please choose the movie you would like to watch by it's corrosponding number");

            //user input for choosing movie by ID
            int movieID = Integer.parseInt(input.nextLine());
            //checking movie chosen within the available ones
            for(Movie movie:whatsOn){
                if(movieID == movie.getID()){
                    chosenMovie = movie;
                }
            }
            //in case chosen movie was found
            if(!chosenMovie.equals(null)){
                System.out.println("You chose " + chosenMovie.getTitle());

                //choosing screening day
                System.out.println("Please choose when the day you want to check screenings for is within a week");
                int daysToDate = Integer.parseInt(input.nextLine());

                //case of day not within a week forwards from now
                if(daysToDate > 7 || daysToDate < 0){
                    System.out.println("Not a valid date");
                }
                //case of day being within a week forwards from today
                else{
                    screenings = Screening.getScreenings(chosenMovie, daysToDate);
                    System.out.println("These are the available screenings on " + parseDate(daysToDate));

                    for (Screening screening: screenings) {
                        System.out.println(screening.getId() + ":\t" + screening.getTime());
                    }
                    //screening being chosen based on it's ID printed next to it's time
                    System.out.println("Please choose the screening you would like by it's ID shown accordingly");

                    //searching for screening after choosing it by ID
                    int screeningID = Integer.parseInt(input.nextLine());
                    for(Screening screening:screenings){
                        if(screeningID == screening.getId()){
                            chosenScreening = screening;
                        }
                    }
                    //in case screening was found
                    if(!chosenScreening.equals(null)){
                        System.out.println("You chose " + chosenScreening.getTime());
                        bookedSeats = Seat.getBookedSeats(screeningID);
                        //checking whether or not the chosen screening has booked seats
                        if(bookedSeats.isEmpty() == false){
                            System.out.println("This Screening has booked seats");
                        }
                        else{
                            System.out.println("This Screening has no booked seats");
                        }
                    }
                    //case of false screening chosen
                    else{
                        System.out.println("Choice of screening does not exist");
                    }
                }
            }
            //case of movie not existing within the provided list
            else{
                System.out.println("Choice of movie does not exist");
            }

            //checking for another session being wanted or not
            System.out.println("Would you like to have another booking session? [yes/no]");
            String newSession = input.nextLine().toLowerCase();
            newSession = "no";
            if(newSession.equals("no")){
                active = false;
            }

            //Clearing screen
            System.out.print("\033[H\033[2J");
        }
        //Goodbye message after finishing system usage
        System.out.println("Thank you for using the Cine-toucan booking system;");

    }

    public static String parseDate(int daysToDate){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, daysToDate);
        date = calendar.getTime();
        return date.toString();
    }
}

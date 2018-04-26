package test;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import src.Seat;
/**
 * Created by sc16tdad on 09/02/18.
 */
public class SeatTest {
    private Seat first;
    private Seat second;
    private Seat third;
    private Seat fourth;
    private Seat fifth;
    private ArrayList<Seat> bookedSeats;
    private ArrayList<Seat> emptyList;

    @Before
    public void setup(){
        bookedSeats = Seat.getBookedSeats(2);
        for (Seat curSeat : bookedSeats) {
            System.out.println("Beginning");
            System.out.println(curSeat.toString());
            System.out.println("End");
        }
        System.out.println(bookedSeats.toString());
        emptyList = Seat.getBookedSeats(1);

        first = new Seat(1, 2, true, 1, 5, false);
        second = new Seat(2, 2, true, 6, 2, true);
//        third = bookedSeats.get(0);
        fourth = new Seat(3,1,false,4,3,true);
        fifth = new Seat(3,1,false,4,3,true);
    }

    public boolean compareLists(ArrayList<Seat> actual, ArrayList<Seat> acquired){
        if (actual.size() != acquired.size()){
            return false;
        }
        else{
            for (int i = 0; i < actual.size(); i++){
                Seat actualSeat = actual.get(i);
                Seat acquiredSeat = acquired.get(i);
                if(actualSeat.equals(acquiredSeat) == false){
                    System.out.println("false2");
                    if(actualSeat.getId() != acquiredSeat.getId()){
                        System.out.println("ID not equal");
                    }
                    if(actualSeat.getScreening_id() != acquiredSeat.getScreening_id()){
                        System.out.println("Screening_id not equal");
                    }
                    if(actualSeat.getVipSeat() != acquiredSeat.getVipSeat()){
                        System.out.println("VipSeat not equal");
                    }
                    if(actualSeat.getRow() != acquiredSeat.getRow()){
                        System.out.println("Row id not equal");
                    }
                    if(actualSeat.getColumn() != acquiredSeat.getColumn()){
                        System.out.println("Column id not equal");
                    }
                    if(actualSeat.getAvailability() != acquiredSeat.getAvailability()){
                        System.out.println("Availability not equal");
                    }
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    public void getSeatsTest(){
        ArrayList<Seat> trialSeat= new ArrayList<>();
        trialSeat.add(fourth);

        ArrayList<Seat> trialSeat2= new ArrayList<>();
        trialSeat2.add(fifth);

        assertThat(compareLists(trialSeat2,trialSeat), is(true));
    }

    @Test
    public void equalityTest(){
        assertTrue(fourth.equals(fifth));
        assertFalse(first.equals(second));
    }
}
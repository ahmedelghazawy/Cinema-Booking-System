import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 * Created by sc16tdad on 09/02/18.
 */
public class ScreeningTest {
    private ArrayList<Screening> screenings;
    private Screening first;
    private Screening second;
    private Screening third;
    private Screening fourth;
    private Screening fifth;
    private Screening sixth;
    private Movie movie = new Movie(1, "spiderman", "blurb", 10.0, 165, "2018-04-15");

    @Before
    public void setup() {
        screenings = Screening.getScreenings(movie, 3);
        first = new Screening(2,"2018-06-10","16:00:00",3,2);
        second = new Screening(6,"2010-07-10","11:10:00",7,3);
        third = new Screening(2,"2018-06-10","16:00:00",3,2);
        fourth = screenings.get(0);
        fifth = new Screening(2,"2018-06-10","16:00:00",3,2);
        sixth = screenings.get(1);
    }

    public boolean compareLists(ArrayList<Screening> actual, ArrayList<Screening> acquired){
        if (actual.size() != acquired.size()){
            return false;
        }
        else{
            for (int i = 0; i < actual.size(); i++){
                Screening actualScreening = actual.get(i);
                Screening acquiredScreening = acquired.get(i);
                if(actualScreening.equals(acquiredScreening) == false){
                    System.out.println("false2");
                    if(actualScreening.getId() != acquiredScreening.getId()){
                        System.out.println("ID not equal");
                    }
                    if(actualScreening.getDate() != acquiredScreening.getDate()){
                        System.out.println("Date not equal");
                    }
                    if(actualScreening.getTime() != acquiredScreening.getTime()){
                        System.out.println("Time not equal");
                    }
                    if(actualScreening.getMovie_id() != acquiredScreening.getMovie_id()){
                        System.out.println("Movie id not equal");
                    }
                    if(actualScreening.getScreen_id() != acquiredScreening.getScreen_id()){
                        System.out.println("Screen id not equal");
                    }
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    public void getScreeningTest(){
        ArrayList<Screening> trialScreening= new ArrayList<>();
        trialScreening.add(fourth);

        ArrayList<Screening> trialScreening2= new ArrayList<>();
        trialScreening2.add(sixth);

        assertThat(compareLists(trialScreening2,trialScreening), is(true));
    }

    @Test
    public void equalityTest(){
        assertTrue(first.equals(third));
        assertFalse(first.equals(second));
        assertTrue(fourth.equals(sixth));
    }

    @Test
    public void numberOfStandardSeatsTest(){
        assertThat(first.numberOfStandardSeats(), is(50));
        assertNotEquals(second.numberOfStandardSeats(), 10);
    }

    @Test
    public void numberOfVipSeatsTest(){
        assertThat(first.numberOfVipSeats(), is(30));
        assertNotEquals(second.numberOfVipSeats(), 17);
    }
}
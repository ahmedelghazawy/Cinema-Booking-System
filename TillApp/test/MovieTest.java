import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 * Created by sc16tdad on 09/02/18.
 */
public class MovieTest {
  private ArrayList<Movie> movies;
  private Movie first;
  private Movie second;
  private Movie third;
  private Movie fourth;
  private Movie fifth;
  private Movie sixth;

  @Before
  public void setup(){
    movies = Movie.getMovies();
    first = new Movie(1, "spoderman", "blurb", 10.0, 165, "2018-04-15");
    second = new Movie(2, "Dr. who", "blurb again", 8.0, 150, "0000-01-01");
    third = new Movie(1, "spoderman", "blurb", 10.0, 165, "2018-04-15");
    fourth = movies.get(0);
    fifth = new Movie(1,"hello", "", 0.0, 110, "");
    sixth = movies.get(1);

  }

  public boolean compareLists(ArrayList<Movie> actual, ArrayList<Movie> acquired){
    if (actual.size() != acquired.size()){
      return false;
    }
    else{
      for (int i = 0; i < actual.size(); i++){
        Movie actualMovie = actual.get(i);
        Movie acquiredMovie = acquired.get(i);
        if(actualMovie.equals(acquiredMovie) == false){

          return false;
        }
      }
      return true;
    }
  }

  @Test
  public void getMoviesTest(){
    ArrayList<Movie> trialMovies= new ArrayList<>();
    Movie movie = new Movie(1,"hello", "", 0.0, 110, "");
    trialMovies.add(fourth);

    ArrayList<Movie> trialMovies2= new ArrayList<>();
    Movie movie2 = new Movie(1,"hello", "", 0.0, 110, "");
    trialMovies2.add(sixth);

    assertThat(compareLists(trialMovies2,trialMovies), is(true));
  }

  @Test
  public void equalityTest(){
    assertTrue(first.equals(third));
    assertFalse(first.equals(second));
    assertTrue(fourth.equals(sixth));
  }

}

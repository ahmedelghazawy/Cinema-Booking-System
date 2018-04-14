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

  @Before
  public void setup(){
    movies = Movie.getMovies();
    first = new Movie(1, "spoderman", "cover/path/", 10.0, "12", "2018-04-15");
    second = new Movie(2, "Dr. who", "cover/path/again/", 8.0, "e", "0000-01-01");
    third = new Movie(1, "spoderman", "cover/path/", 10.0, "12", "2018-04-15");
    fourth = movies.get(0);
    fifth = new Movie(1,"hello", "", 0.0, "", "");

  }

  public boolean compareLists(ArrayList<Movie> actual, ArrayList<Movie> acquired){
    if (actual.size() != acquired.size()){
      System.out.println("false1");
      return false;
    }
    else{
      for (int i = 0; i < actual.size(); i++){
        Movie actualMovie = actual.get(i);
        Movie acquiredMovie = acquired.get(i);
        if(actualMovie.equals(acquiredMovie) == false){
          System.out.println("false2");
          if(actualMovie.getID() != acquiredMovie.getID()){
            System.out.println("ID not equal");
          }
          if(actualMovie.getTitle() != acquiredMovie.getTitle()){
            System.out.println("Title not equal");
            System.out.println(acquiredMovie.getTitle() + " acquired");
            System.out.println(actualMovie.getTitle() + " actual");
          }
          if(actualMovie.getCover() != acquiredMovie.getCover()){
            System.out.println("cover not equal");
          }
          if(actualMovie.getRating() != acquiredMovie.getRating()){
            System.out.println("rating not equal");
          }
          if(actualMovie.getCertificate() != acquiredMovie.getCertificate()){
            System.out.println("Certificate not equal");
          }
          if(actualMovie.getReleaseDate() != acquiredMovie.getReleaseDate()){
            System.out.println("release date not equal");
          }
          return false;
        }
      }
      System.out.println("true");
      return true;
    }
  }

  @Test
  public void getMoviesTest(){
    ArrayList<Movie> trialMovies= new ArrayList<>();
    Movie movie = new Movie(1,"hello", "", 0.0, "", "");
    trialMovies.add(movie);
    assertThat(compareLists(movies,trialMovies), is(false));
  }

  @Test
  public void equalityTest(){
    assertTrue(first.equals(third));
    assertFalse(first.equals(second));
    assertTrue(fourth.equals(fifth));
  }

}

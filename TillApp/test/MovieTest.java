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

  @Before
  public void setup(){
    movies = Movie.getMovies();
  }

  @Test
  public void getMoviesTest(){
    ArrayList<Movie> trialMovies= new ArrayList<>();
    trialMovies.add(new Movie(1,"hello", "", 0.0, "", ""));
    assertThat(movies, is(trialMovies));
  }
}

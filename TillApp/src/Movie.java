import java.util.List;
import java.lang.*;
import java.sql.Timestamp;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 * Created by sc16tdad on 09/02/18.
 */
public class Movie {
    private String title;
    private String certificate;
    private Timestamp duration;
    //private List<Screening> screenings;

    public String getTitle() {
        return title;
    }

    public String getCertificate() { return certificate; }

    public Timestamp getDuration(){ return duration; }

    @Override
    public String toString() { return title; }
}

class MovieData {

    public static void queryTitle(Sql2o database)
    {

        System.out.println("\nTitle:\n");

        try (Connection conn = database.open())
        {
            List<Movie> movies = conn.createQuery("SELECT title, certificate, duration FROM source_movie").executeAndFetch(Movie.class);

            for (Movie movie: movies)
            {
                System.out.println(movie.toString());
            }
        }

    }

    public static void main(String[] args) {
      Sql2o db = new Sql2o("jdbc:sqlite:../../WebApp/Application/databse.db", "", "");
      queryTitle(db);
    }
}

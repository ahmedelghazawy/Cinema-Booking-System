import java.sql.Timestamp;
import java.util.List;
import java.lang.*;
import java.sql.Timestamp;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 * Created by sc16tdad on 09/02/18.
 */
public class Screening {

    private int id;
    private int movie_id_id;
    private Timestamp screen_id_id;

    public int getMovieID() { return movie_id_id; }

    public Timestamp getScreenID() { return screen_id_id; }
}

class ScreeningData {

    public static void queryScreening(Sql2o database)
    {

        System.out.println("\nTitle:\n");

        try (Connection conn = database.open())
        {
            List<Screening> screenings = conn.createQuery("SELECT * FROM source_screening").executeAndFetch(Screening.class);

            for (Screening screening: screenings)
            {
                System.out.println(screening.getMovieID());
            }
        }

    }
}

import java.util.List;

/**
 * Created by sc16tdad on 09/02/18.
 */
public class Movie {
    private String movieName;
    private String certificate;
    private List<Screening> screenings;

    public String getMovieName() {
        return movieName;
    }

    public String getCertificate() {
        return certificate;
    }
}

import java.util.List;

/**
 * Created by sc16tdad on 09/02/18.
 */
public class Movie {
    private String title;
    private String certificate;
    private List<Screening> screenings;

    public String getTitle() {
        return title;
    }

    public String getCertificate() { return certificate; }

    @Override
    public String toString() { return title; }
}

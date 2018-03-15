import java.util.List;

/**
 * Created by sc16tdad on 09/02/18.
 */
public class Movie {
    private String title = "";
    private int id = 0;
    private String cover = "";
    private double rating = 0;
    private String releaseDate = "";
    private String certificate = "";
    private List<Screening> screenings;

    public Movie(){
        this.id = 0;
        this.title = null;
    }

    public Movie(int id, String title)
    {
        this.id = id;
        this.title = title;
    }

    public String getTitle() { return title; }

    public String getCertificate() { return certificate; }

    @Override
    public String toString() { return title; }
}

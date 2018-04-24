import org.codehaus.jackson.map.ObjectMapper;
import java.util.*;
import java.net.*;
import java.io.*;

public class Screen {

    private int id;
    private int standardSeats;
    private int vipSeats;

    public Screen() {
        this.id = 0;
        this.standardSeats = 0;
        this.vipSeats = 0;
    }

    public Screen(int id, int standardSeats, int vipSeats) {
        this.id = id;
        this.standardSeats = standardSeats;
        this.vipSeats = vipSeats;
    }

    public int getId() { return id; }

    public int getStandardSeats() { return standardSeats; }

    public int getVipSeats() { return vipSeats; }

    public void setId() { this.id = id; }

    public void setStandardSeats() { this.standardSeats = standardSeats; }

    public void setVipSeats() { this.vipSeats = vipSeats; }

    public static Screen getScreen(int screening_id) {

        Screen screen = null;
        try
        {
            //URL for the API
            String url = "http://127.0.0.1:8000/api/screenapi/" + screening_id + "/?format=json";

            // Part of the Jackson library, creating a mapper to map the json object to the screening object
            ObjectMapper mapper = new ObjectMapper();
            String[] jsons = APIConnection.get(url);
            screen = mapper.readValue(jsons[0], Screen.class);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return screen;
    }

}

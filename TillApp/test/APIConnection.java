package test;
import java.lang.*;

public class APIConnection{
  public static String[] get(String url) throws Exception{
    String[] array = new String[2];
    if(url.contains("whatsonapi")){
      array[0] = "{\"id\":1, \"title\":\"\", \"blurb\":\"\", \"rating\":0.0, \"certificate\":\"\", \"duration\":110}";
      array[1] = "{\"id\":1, \"title\":\"\", \"blurb\":\"\", \"rating\":0.0, \"certificate\":\"\", \"duration\":110}";
    }
    else if(url.contains("movieTimingsapi")){
      array[0] = "{\"id\":1, \"date\": \"2018-04-27\", \"time\":\"15:00:00\", \"movie_id\":1, \"screen_id\":2}";
      array[1] = "{\"id\":1, \"date\": \"2018-04-27\", \"time\":\"15:00:00\", \"movie_id\":1, \"screen_id\":2}";
    }
    else if(url.contains("screenapi")){
        array[0] = "{\"id\":1, \"standardSeats\": 50, \"vipSeats\":30}";
    }
    else if(url.contains("seatingapi/1")){
        array[0] = "";
    }
    else if(url.contains("seatingsapi/2")){
        array[0] = "{\"id\":1, \"vipSeat\":true, \"row\":1, \"column\":5}";
    }
    return array;
  }

  public static int post(String link, String json) throws Exception{
      if (link.contains("seatingapi/1")){
          return 0;
      }
      else if (link.contains("seatingapi/2")){
          return 1;
      }
      return 0;
  }
}

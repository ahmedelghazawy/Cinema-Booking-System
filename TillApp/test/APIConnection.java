import java.lang.*;
public class APIConnection{
  public static String[] get(String url) throws Exception{
    String[] array = new String[1];
    if(url.contains("whatsonapi")){
      array[0] = "{\"id\":1, \"title\":\"hello\", \"blurb\":\"\", \"rating\":0.0, \"certificate\":\"\", \"duration\":110}";
    }
    else if(url.contains("movieTimingsapi")){
      array[0] = "{\"id\":1, \"date\": \"2018-04-12\", \"time\":\"10:00:00\", \"movie_id\":1, \"screen_id\":2}";
    }
    return array;
  }

}

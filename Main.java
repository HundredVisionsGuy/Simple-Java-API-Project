import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import org.json.JSONObject;

class Main {
  public static void main(String[] args) throws Exception {
    try {
      // Host URL, endpoint, and query
      String host = "http://api.icndb.com";
      String endpoint = "/jokes/random";
      String query = "?limitTo=[nerdy]";

      // put it all together into the api call
      String url = host + endpoint + query;

      HttpResponse <JsonNode> response = Unirest.get( url )
        .asJson(); 
      
      // Test the response
      System.out.println(response.getStatus());
      System.out.println(response.getBody().toString());
      
    }

    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.Arrays;

// import json-simple api
// use https://www.geeksforgeeks.org/parse-json-java/ for our reference

class Main {
  public static void main(String[] args) {
    try {
      // Host URL, endpoint, and query
      String host = "https://dog.ceo/";
      String endpoint = "/api/breeds/list/all";
      String query = "";

      // put it all together into the api call
      String url = host + endpoint + query;

      // Let's make the call & store result as a string
      String result = Unirest.get(url)
          .asJson()
          .getBody()
          .getObject()
          .toString();

      //System.out.println(result + "\n\n\n");
      result = "[" + result + "]";

      // Let's try a JSONArray
      JSONArray array = new JSONArray(result);
      // JSONObject breedsObject = array.getJSONObject(0);
      String breeds = array.getJSONObject(0).optString("message");
      //System.out.println(poodleBreeds);
      breeds = "[" + breeds + "]";

      JSONArray breedsArray = new JSONArray(breeds);
      JSONObject jsonObject = breedsArray.getJSONObject(0);
      String new_breeds = jsonObject.keySet().toString
      //System.out.println(new_breeds);
      
      //System.out.println(breeds);
      int start = 1, stop;
      stop = new_breeds.length()-1;
      new_breeds = new_breeds.subSequence(start, stop).toString();
      ArrayList<String> myList = new ArrayList<String>(
        Arrays.asList(
          new_breeds.split(", ")
          )
        );
      for (String b : myList) {
        System.out.println(b);
      }
      // System.out.println(myList);
    }

    catch (Exception e) {
      e.printStackTrace();
    }    
  }

}

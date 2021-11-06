import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;

// We need to import gson package from google
// imports below for parsing JSON
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

// Let's try org.json
import org.json.JSONObject;
import org.json.JSONArray;

// import json-simple api
// use https://www.geeksforgeeks.org/parse-json-java/ for our reference

class Main {
  public static void main(String[] args) throws Exception {
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
      JSONObject breedsObject = array.getJSONObject(0);
      String breeds = breedsObject.optString("message");
      System.out.println(poodleBreeds);
      breeds = "[" + breeds + "]";

      JSONArray breedsArray = new JSONArray(breeds);
      JSONObject object = breedsArray.getJSONObject(0);
      String new_breeds = object.keySet().toString();
      //System.out.println(new_breeds);
      
      //System.out.println(breeds);
      int start = 1, stop;
      stop = new_breeds.length()-1;
      new_breeds = new_breeds.subSequence(start, stop).toString();
      ArrayList<String> myList = new ArrayList<String>(Arrays.asList(new_breeds.split(", ")));
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

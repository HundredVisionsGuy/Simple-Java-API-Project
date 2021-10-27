import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import java.awt.*;
import javax.swing.JFrame;

import org.json.JSONObject;

class Main extends Canvas {
  public void paint(Graphics g) {
    Toolkit t=Toolkit.getDefaultToolkit();
    Image i=t.getImage("transact-sql.png");
    g.drawImage(i, 120, 100, this);
  }
  public static void main(String[] args) throws Exception {
    try {
      // Host URL, endpoint, and query
      String host = "https://dog.ceo/";
      String endpoint = "/api/breeds/list/all";
      String query = "";

      // put it all together into the api call
      String url = host + endpoint + query;

      HttpResponse <JsonNode> response = Unirest.get( url )
        .asJson(); 
      
      // Test the response
      System.out.println(response.getStatus());
      System.out.println(response.getBody().toString());

      Main m = new Main();
      JFrame f=new JFrame();
      f.add(m);
      f.setSize(400,400);
      f.setVisible(true);
      
    }

    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
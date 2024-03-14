import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private TextField City;

    @FXML
    private Button getData;

    @FXML
    private Text temp_feels;

    @FXML
    private Text temp_info;

    @FXML
    private Text temp_max;

    @FXML
    private Text temp_min;

    @FXML
    private Text temp_pres;

    @FXML
    void initialize() {
        getData.setOnAction(event -> {
            
            String getUserCity = City.getText().trim();
            if (!getUserCity.equals("")) {
                String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=" + getUserCity + "&appid=c98483feca2e235c5c18fde5c76c529f&units=metric");
                
                if (!output.isEmpty()) {
                    JSONObject obj = new JSONObject(output);
                    temp_info.setText("Temperature: " + obj.getJSONObject("main").getDouble("temp"));
                    temp_feels.setText("Feels: " + obj.getJSONObject("main").getDouble("feels_like"));
                    temp_max.setText("Max: " + obj.getJSONObject("main").getDouble("temp_max"));
                    temp_min.setText("Min: " + obj.getJSONObject("main").getDouble("temp_min"));
                    temp_pres.setText("Pressure: " + obj.getJSONObject("main").getDouble("pressure"));
                }
            }
        });

    }

    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch(Exception e) {
            System.out.println("City not found");
        }
        return content.toString();
    }

}

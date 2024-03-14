import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("weat.fxml"));
            primaryStage.setTitle("Weather App");
            primaryStage.setScene(new Scene(root, 255, 350));
            primaryStage.setResizable(false);
            primaryStage.show();
        } 
        catch (Exception e) 
        {
           
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
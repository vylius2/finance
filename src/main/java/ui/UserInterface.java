package ui;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class UserInterface extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       Parent root = null;
       try {
           root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/start.fxml")));
       } catch (Exception e){
           e.printStackTrace();
       }
        assert root != null;
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Finansai");
        stage.show();
    }



}

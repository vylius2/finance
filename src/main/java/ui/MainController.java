package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController {
    public void onClickEvent(MouseEvent mouseEvent) throws IOException {
        Parent outcome = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/islaidos.fxml")));
        Scene scene = new Scene(outcome);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Islaidos");
        stage.show();
    }
}

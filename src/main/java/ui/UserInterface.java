//package ui;
//
//
//import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.File;
//import java.net.URL;
//
//public class UserInterface extends Application {
//
//    @Override
//    public void start(Stage stage) throws Exception {
//       Parent root = null;
//       URL url = null;
//
//       try {
//           url = getClass().getResource("src/main/resources/start.fxml");
//           root = FXMLLoader.load(url);
//           System.out.println("fxmlResource: " + url.toString() + root.toString());
//       } catch (Exception e){
//           System.out.println("fxmlurl: " + url.toString());
//           System.out.println("fxmlrootTO String" + root.toString());
//       }
//
//
//        stage.setTitle("Finansai");
//        stage.show();
//    }
//
//
//
//}

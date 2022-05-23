import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application 
{

  public static void main(String[] args) 
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception 
  {
    URL url = getClass().getResource("UI.fxml");
    FXMLLoader loader = new FXMLLoader(url);
    Parent root = loader.load();
    Scene tela = new Scene(root);

    primaryStage.setTitle("Golens Antigos");
    primaryStage.setScene(tela);
    primaryStage.show();
  }
}

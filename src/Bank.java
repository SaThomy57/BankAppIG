import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Bank extends Application {
    public void start(Stage stage){
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root,1200,800);
        stage.setScene(scene);
        stage.setTitle("Bank");
        stage.show();
    }
}
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Bank extends Application {
    public void start(Stage stage){
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root,1200,800);

        // Chargement de l'icone de l'application
        try{
            Image icon = new Image(getClass().getResourceAsStream("/icon/bankIcon.png"));
            stage.getIcons().add(icon);
        }catch(Exception e){
            System.err.println("Impossible de charger l'icone : " + e.getMessage() + " !");
        }

        // Chargement de l'image de fond
        /*try {
            Image backgroundImage = new Image(getClass().getResourceAsStream("/icon/bankIcon.png"));

            // Création du BackgroundImage
            BackgroundImage bgImage = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT, // Pas de répétition horizontale
                    BackgroundRepeat.NO_REPEAT, // Pas de répétition verticale
                    BackgroundPosition.CENTER,  // Centré
                    new BackgroundSize(
                            BackgroundSize.AUTO,
                            BackgroundSize.AUTO,
                            true, true, true, false
                    )
            );
            root.setBackground(new Background(bgImage));
            // Calque de transparence
            Pane pane = new Pane();
            pane.setBackground(new Background(
                    new BackgroundFill(Color.rgb(0, 0, 0, 0.3), null, null)
            ));

        } catch (Exception e) {
            System.err.println("Erreur chargement image : " + e.getMessage());
        }*/

        stage.setScene(scene);
        stage.setTitle("Bank");
        stage.show();
    }
}
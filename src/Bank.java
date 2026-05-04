import Bank.util.controller.MainController;
import Bank.viewModel.BanqueViewModel;
import Bank.viewModel.stubViewModel.StubBanqueViewModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class Bank extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Remplacement du BorderPane par le BanqueViewModel
        BanqueViewModel banqueVM = new StubBanqueViewModel();

        //Verification du chemin
        java.net.URL resource = getClass().getResource("/Bank/view/MainView.fxml");
        if (resource == null) {
            System.err.println("ERREUR : Fichier FXML introuvable dans /Bank/view/MainView.fxml");
            System.err.println("Vérifiez que le dossier 'view' est bien dans 'src/Bank/'");
            return;
        }

        FXMLLoader loader = new FXMLLoader(resource);

        // Configuration de la ControllerFactory
        loader.setControllerFactory(clazz->{
            if(clazz ==MainController.class){
                MainController controller = new MainController();
                controller.initializeVM(banqueVM);
                return controller;
            }
            return null;
        });


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

        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle("Bank");
        stage.show();
    }
}
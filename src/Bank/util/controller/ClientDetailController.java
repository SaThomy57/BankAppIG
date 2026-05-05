package Bank.util.controller;

import Bank.BankApp;
import Bank.viewModel.ClientDetailsViewModel;
import Bank.viewModel.CompteViewModel;
import Bank.viewModel.stubViewModel.StubBanqueViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.EventObject;
import javafx.event.ActionEvent;

public class ClientDetailController {
    @FXML
    private Label nomClientLabel;
    @FXML
    private Label soldeTotalLabel;
    private ClientDetailsViewModel viewModel;
    @FXML
    private ListView<CompteViewModel> compteListView;
    @FXML
    private PieChart budgetPieChart;

    public void initializeVM(ClientDetailsViewModel viewModel){
        this.viewModel= viewModel;
    }
    @FXML
    public void initialize(){
        //Ligne qui permet de lire le nom complet du client sur sa page d'information
        nomClientLabel.setText(viewModel.nomCompletProperty().getValue());

        if (viewModel != null && nomClientLabel != null && soldeTotalLabel != null) {
            if (compteListView != null) {
                compteListView.setCellFactory(listView -> new CompteCellController());
            }
            // Methode de la liste et du graphique
            setupBidings();
        }
    }

    /**
     * Methode pour afficher une liste de comptes ainsi qu'un graphique budgetaire
     */
    private void setupBidings() {
        nomClientLabel.textProperty().bind(viewModel.nomCompletProperty());
        soldeTotalLabel.textProperty().bind(viewModel.soldeTotalProperty().asString("%.2f €"));

        if (compteListView != null) {
            compteListView.setItems(viewModel.getComptesOfClient());
        }
        if (budgetPieChart != null) {
            budgetPieChart.setData(viewModel.getStaticClientBudget());
            budgetPieChart.setLabelsVisible(true); // Affiche les noms
            budgetPieChart.setTitle("Patrimoine");
            budgetPieChart.setClockwise(false);
        }
    }
    /**
     * Bouton de retour a la liste
     */
    @FXML
    private void handleRetour(ActionEvent event){
        try{
            // Charger la vue de la liste de client
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Bank/view/MainView.fxml"));

            // On recree la vue de Bank.java
            loader.setControllerFactory(clazz->{
                if (clazz == MainController.class){
                    MainController controller = new MainController();
                    controller.initializeVM(BankApp.getBanqueVM());
                    return controller;
                }
                return null;
            });

            Parent root = loader.load();
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        }catch(IOException e){
            System.err.println("Erreur lors du retour a la liste client : " + e.getMessage());
        }
    }
}

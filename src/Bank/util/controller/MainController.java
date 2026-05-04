package Bank.util.controller;

import Bank.model.Client;
import Bank.viewModel.BanqueViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {
    @FXML
    private TextField searchField;
    @FXML
    private ListView<Client> clientListView;
    private BanqueViewModel banqueVM;

    //Injection du viewModel avec le ControlerFactory
    public void initializeVM(BanqueViewModel banqueVM){
        this.banqueVM = banqueVM;
        setupBidings();
    }

    private void setupBidings() {
        if(searchField != null && banqueVM != null) {
            // Liaison bidirectionnelle de la barre de recherche
            searchField.textProperty().bindBidirectional(banqueVM.filtreTexteProperty());
            //ListView observe la liste triée dans la banqueVM
            clientListView.setItems(banqueVM.getClientsTrier());
        }
    }
    @FXML
    private void handleAjouterClient(){
        //Appelle la methode d'ajout definie dans 'BanqueViewModel'
        banqueVM.ajouterClientSimple(new Client(0, "Nouveau", "Usager", null));
    }

    @FXML
    private void handleTri(){
        //Le tri n'est pas géré ici
    }
}

package Bank.util.controller;

import Bank.model.Client;
import Bank.viewModel.BanqueViewModel;
import Bank.viewModel.stubViewModel.StubClientDetailsViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainController {
    @FXML
    private TextField searchField;
    @FXML
    private ListView<Client> clientListView;
    private BanqueViewModel banqueVM;
    @FXML
    private BorderPane mainPane;

    //Injection du viewModel avec le ControlerFactory
    public void initializeVM(BanqueViewModel banqueVM){
        this.banqueVM = banqueVM;
        setupBidings();
    }

    @FXML
    public void initialize(){
        // On définit le style de la liste
        clientListView.setCellFactory(listView -> new UserCellController());

        // ecoute le clic sur client
        clientListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                // Affichage simple
                //System.out.println("Selection : " + newValue.getNomComplet());
                afficherDetailsClient(newValue);
            }
        });
        if (banqueVM != null) setupBidings();
    }

    private void setupBidings() {
        if(searchField != null && banqueVM != null) {
            // Liaison bidirectionnelle de la barre de recherche
            searchField.textProperty().bindBidirectional(banqueVM.filtreTexteProperty());
            //ListView observe la liste triée dans la banqueVM
            clientListView.setItems(banqueVM.getClientsTrier());
        }
    }

    /**
     * Permet d'afficher les details du client et met a jour le BorderPane
     * @param client
     */
    private void afficherDetailsClient(Client client){
        try{
            // On cree la VM et on lui donne le client
            StubClientDetailsViewModel detailVM = new StubClientDetailsViewModel();
            detailVM.updateFromClient(client);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Bank/view/ClientDetailView.fxml"));

            // Injection dans la factory
            loader.setControllerFactory(clazz->{
                if (clazz == ClientDetailController.class){
                    ClientDetailController controller = new ClientDetailController();
                    controller.initializeVM(detailVM);
                    return controller;
                }
                return null;
            });

            Parent view = loader.load();
            mainPane.setCenter(view);
        } catch (IOException e){
            e.printStackTrace();
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
    @FXML
    private void handleCLientSelection(Client client){
        if (client == null) return;

        try{
            StubClientDetailsViewModel detailVM = new StubClientDetailsViewModel();
            // Utilisation des donnees du client selectionné
            detailVM.updateFromClient(client);

            //Chargement  de la vue detaillee
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Bank/view/ClientDetailsView.fxml"));

            //utilisation du controllerFactory
            loader.setControllerFactory(clazz->{
                if (clazz == ClientDetailController.class){
                    ClientDetailController controller = new ClientDetailController();
                    controller.initializeVM(detailVM);
                    return controller;
                }
                return null;
            });

            Parent detailView = loader.load();

            System.out.println("Affichage des détails: " + client.getNomComplet());

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

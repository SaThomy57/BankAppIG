package Bank.util.controller;

import Bank.model.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class UserCellController extends ListCell<Client> {
    @FXML
    private Label nomCompletLabel;
    @FXML
    private Label detailsLabel;
    @FXML
    private HBox root;
    private FXMLLoader loader;

    @Override
    protected void updateItem(Client client, boolean empty) {
        super.updateItem(client, empty);

        if(empty || client == null) {
            setGraphic(null);
            setText(null);
        } else {
            if (loader == null){
                loader = new FXMLLoader(getClass().getResource("/Bank/view/UserCell.fxml"));
                loader.setController(this);
                try{
                    loader.load();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            // Récupération des données du modele
            nomCompletLabel.setText(client.getNomComplet());
            detailsLabel.setText("ID: "+ client.getId());

            setGraphic(loader.getRoot());
        }
    }
}

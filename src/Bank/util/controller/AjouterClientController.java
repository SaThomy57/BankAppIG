package Bank.util.controller;

import Bank.model.Client;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjouterClientController {
    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private DatePicker dateNaissancePicker;

    private Client nouveauClient;

    @FXML
    private void handleEnregistrer(){
        if (nomField != null && prenomField != null && dateNaissancePicker != null) {
            nouveauClient = new Client(0, nomField.getText(), prenomField.getText(), dateNaissancePicker.getValue());
        }
        closeStage();
    }
    @FXML
    private void handleAnnuler(){
        nouveauClient = null;
        closeStage();
    }
    private void closeStage(){
        Stage stage = (Stage) nomField.getScene().getWindow();
        stage.close();
    }
    public Client getNouveauClient(){
        return nouveauClient;
    }
}

package Bank.util.controller;

import Bank.model.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        // On récupere les valeurs et on supprime les espaces avec trim()
        String nom = nomField.getText().trim();
        String prenom = prenomField.getText().trim();

        //Requiered : conditions d'obligation
        if (nom.isEmpty() || prenom.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champs obligatoires");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs obligatoires !");
            alert.showAndWait();
            return;
        }

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

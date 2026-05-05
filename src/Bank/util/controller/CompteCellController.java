package Bank.util.controller;

import Bank.viewModel.CompteViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class CompteCellController extends ListCell<CompteViewModel> {
    @FXML
    private Label typeCompteLabel;
    @FXML
    private Label soldeLabel;
    @FXML
    private HBox root;
    private FXMLLoader loader;

    @Override
    protected void updateItem(CompteViewModel compte, boolean empty) {
        super.updateItem(compte, empty);
        if(empty || compte == null) {
            setGraphic(null);
        } else {
            if (loader == null){
                loader = new FXMLLoader(getClass().getResource("/Bank/view/CompteCell.fxml"));
                loader.setController(this);
                try{
                    loader.load();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            typeCompteLabel.setText(compte.getType());
            soldeLabel.setText(String.format("%.2f €", compte.getSolde()));
            setGraphic(root);
        }
    }
}

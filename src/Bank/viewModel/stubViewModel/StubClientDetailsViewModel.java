package Bank.viewModel.stubViewModel;

import Bank.model.*;
import Bank.viewModel.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class StubClientDetailsViewModel implements ClientDetailsViewModel {
    private final StringProperty nomComplet = new SimpleStringProperty("");
    private final DoubleProperty soldeTotal = new SimpleDoubleProperty(0.0);
    private final ObservableList<CompteViewModel> comptes = FXCollections.observableArrayList();
    private final ObservableList<TransactionViewModel> transactions = FXCollections.observableArrayList();
    private final ObservableList<PieChart.Data> statBudget = FXCollections.observableArrayList();

    // Methode d'injection d'un client et de mise a jour de son nomComplet
    public void updateFromClient(Client client){
        if (client != null) {
            nomComplet.set(client.getNomComplet());
            soldeTotal.set(client.getSoldeTotal());
        }
    }
    @Override
    public StringProperty nomCompletProperty() {
        return nomComplet;
    }
    @Override
    public DoubleProperty soldeTotalProperty(){
        return soldeTotal;
    }
    @Override
    public ObservableList<CompteViewModel> getComptesOfClient() {
        return comptes;
    }
    @Override
    public ObservableList<TransactionViewModel> getTransactionsOfCompte() {
        return transactions;
    }
    /*@Override
    public ObservableList<PieChart.Data> getStaticClientBudget() {
        return statBudget;
    }*/
    @Override
    public ObservableList<PieChart.Data> getStaticClientBudget() {
        // On simule des parts de budget basées sur les comptes ou des catégories
        return FXCollections.observableArrayList(
                new PieChart.Data("Compte Courant", 1500),
                new PieChart.Data("Livret A", 4500),
                new PieChart.Data("Épargne Logement", 2000)
        );
    }
    @Override
    public void setCompteActif(Compte compte) {
        // Aucune implementation dans ce fichier
    }
}

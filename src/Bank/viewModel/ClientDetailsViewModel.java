package Bank.viewModel;

import Bank.model.Compte;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public interface ClientDetailsViewModel {
    StringProperty nomCompletProperty();
    DoubleProperty soldeTotalProperty();

    //Liste des comptes du client
    ObservableList<CompteViewModel> getComptesOfClient();

    //Liste des tr(ansaction du comptes du client
    ObservableList<TransactionViewModel> getTransactionsOfCompte();

    //Donnees du graphique du client
    ObservableList<PieChart.Data> getStaticClientBudget();

    //Action de changemetn du compte actif + MAJ des transactions et du graphique
    void setCompteActif(Compte compte);
}

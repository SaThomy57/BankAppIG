package Bank.viewModel.stubViewModel;

import Bank.model.Client;
import Bank.viewModel.BanqueViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 * Ici on définit le filtrage et le tri pour qu'ils soient complémentaires sans s'annuler
 */

public class StubBanqueViewModel implements BanqueViewModel {
    private final ObservableList<Client> clients = FXCollections.observableArrayList();
    private final StringProperty filtre = new SimpleStringProperty("");

    // COnstructeur
    public StubBanqueViewModel() {
        // Donne de test immédiate
        clients.add(new Client(1, "Lacroix", "Bryan", LocalDate.of(1995, 10, 17)));
        clients.add(new Client(2, "Dupont", "Jean", LocalDate.of(1990, 1, 12)));
    }

    @Override
    public ObservableList<Client> getClientsTrier() {
        return clients;
    }
    @Override
    public StringProperty filtreTexteProperty() {
        return filtre;
    }
    @Override
    public void ajouterClientSimple(String nom, String prenom, String dateNaissance) {
        clients.add(new Client(clients.size() + 1, nom, prenom, LocalDate.parse(dateNaissance)));
    }
}

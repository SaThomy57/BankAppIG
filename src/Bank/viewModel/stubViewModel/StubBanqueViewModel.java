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

    @Override
    public ObservableList<Client> getClientsTrier() {
        return clients;
    }
    @Override
    public StringProperty filtreTexteProperty() {
        return filtre;
    }
    @Override
    public void ajouterClientSimple(Client client) {
        clients.add(client);
    }
}

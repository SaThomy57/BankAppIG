package Bank.viewModel;

import Bank.model.Client;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public interface BanqueViewModel {
    // La liste que la vue va afficher
    ObservableList<Client> getClientsTrier();

    // la propriete de la barre de recherche
    StringProperty filtreTexteProperty();

    // Methode d'ajout d'un client
    void ajouterClientSimple(Client client);

    // Methode de tri
    void trierClients(String trierPar);
    boolean isAscendant();
}

package Bank.viewModel.stubViewModel;

import Bank.model.Client;
import Bank.model.Compte;
import Bank.model.TypeCompte;
import Bank.viewModel.BanqueViewModel;
import Bank.viewModel.CompteViewModel;
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
    private int dernierId = 0;
    private String dernierTri = "";
    private boolean ascendant = true;

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
        dernierId++;
        // Toutes les informations proviennent de la popUp
        Client clientFinalId = new Client(dernierId, client.getNom(), client.getPrenom(), client.getDateNaissance(),
                client.getAdresse(), client.getEmail(), client.getTelephone()
        );

        // Logique d'attribution de compte courant par defaut

        Compte compteCourant = new Compte(TypeCompte.Courant, 50.0);
        clientFinalId.ajouterCompte(compteCourant);
        clients.add(clientFinalId);
    }

    @Override
    public void trierClients(String trierPar) {
        if (trierPar.equals(dernierTri)){
            ascendant = !ascendant;
        }else{
            ascendant = true;
            dernierTri = trierPar;
        }
        switch (trierPar.toLowerCase()) {
            case "id":
                clients.sort((c1, c2) -> ascendant ?
                        Integer.compare(c1.getId(), c2.getId()) :
                        Integer.compare(c2.getId(), c1.getId())
                        );
                break;
            case "nom":
                // On trie par nom et si le nom est identique par prénom
                clients.sort((c1, c2) -> {
                    int res = c1.getNom().compareToIgnoreCase(c2.getNom());
                    if (res == 0) return c1.getPrenom().compareToIgnoreCase(c2.getPrenom());
                    return ascendant ? res : -res;
                });
                break;
        }
    }

    @Override
    public boolean isAscendant(){
        return ascendant;
    }

}

package Bank.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banque {
    private String nom;
    private List<Client> clients;

    //COnstructeur
    public Banque(String nom) {
        this.nom = nom;
        this.clients = new ArrayList<>();
    }

    public void ajouterClient(Client client) {
        if (clients != null) clients.add(client);
    }
    public void retirerClient(Client client) {
        if (clients != null) clients.remove(client);
    }

    // Getter & Setter
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }
    public int getNbClients() {
        return clients.size();
    }
    /**
     * Renvoie le client avec un identifiant précis dans la liste
     * @param id
     * @return
     */
    public Client getClientById(int id) {
        for (Client client : clients) {
            if (client.getId() == id) return client;
        }
        return null;
    }

}

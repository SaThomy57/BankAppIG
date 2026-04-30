package Bank.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    // Attribut essentiel à un client
    private final int id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private List<Compte> comptes;

    // Attribut essentiel complémentaire à un client
    private String adresse;
    private String email;
    private String telephone;

    // Constructeurs
    public Client(int id, String nom, String prenom, String dateNaissance, String adresse, String email, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        comptes = new ArrayList<>();
    }
    public Client(int id, String nom, String prenom, String dateNaissance) {
        this(id, nom, prenom, dateNaissance, null, null, null);
    }

    //Solde totale
    public double getSoldeTotal() {
        double soldeTotal = 0;
        for (Compte compte : comptes) {
            soldeTotal += compte.getSolde();
        }
        return soldeTotal;
    }

    // AJout & retrait d'un cmpte de la liste
    public void ajouterCompte(Compte compte) {
        comptes.add(compte);
    }
    public void retirerCompte(Compte compte) {
        comptes.remove(compte);
    }

    //Getter
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getDateNaissance() {
        return dateNaissance;
    }
    public List<Compte> getComptes() {
        return comptes;
    }
    public Compte getCompte(int id) {
        return comptes.get(id);
    }

    // Getter complementaire
    public String getAdresse() {
        return adresse;
    }
    public String getEmail() {
        return email;
    }
    public String getTelephone() {
        return telephone;
    }

    //Setter
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    // Setter complementaire
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

package Bank.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    // Attribut essentiel à un client
    private final int id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private List<Compte> comptes;

    // Attribut essentiel complémentaire à un client
    private String adresse;
    private String email;
    private String telephone;

    // Constructeurs
    public Client(int id, String nom, String prenom, LocalDate dateNaissance, String adresse, String email, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        comptes = new ArrayList<>();
    }
    public Client(int id, String nom, String prenom, LocalDate dateNaissance) {
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
        if (comptes != null) comptes.add(compte);
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
    public String getNomComplet() {
        return nom + " " + prenom;
    }
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    public List<Compte> getComptes() {
        return Collections.unmodifiableList(comptes);
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
    public void setDateNaissance(LocalDate dateNaissance) {
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

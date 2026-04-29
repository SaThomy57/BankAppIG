package Bank.model;

import java.time.LocalDate;

public class Transaction {
    private final double montant;
    private final LocalDate date;   // ex: 15.04 -> date immuable
    private final String libelle;    // ex: Anniversaire
    private final String categorie; // ex: Alimentation, Transport, ...

    //Constructeur de la transaction
    public Transaction(double montant, LocalDate date, String libelle, String categorie) {
        this.montant = montant;
        this.date = date;
        this.libelle = libelle;
        this.categorie = categorie;
    }

    // Getter
    public double getMontant() {
        return montant;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getLibelle() {
        return libelle;
    }
    public String getCategorie() {
        return categorie;
    }

    //Affichage formater
    @Override
    public String toString(){
        return String.format("%s - %s - %s", montant, date, libelle);
    }
}

package Bank.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Bank.util.BankUtils.genererIbanFRANCE;

public class Compte {
    private final TypeCompte type;
    private final String iban;
    private double solde;
    private final List<Transaction> transactions;

    // COnstructeur d'un compte bancaire
    public Compte(TypeCompte type, double solde) {
        this.type = type;
        this.iban = genererIbanFRANCE();
        this.solde = solde;
        this.transactions = new ArrayList<>();
    }

    public void ajouterTransaction(Transaction transaction) {
        transactions.add(transaction);
        solde += transaction.getMontant();
    }
    public void retirerTransaction(Transaction transaction) {
        transactions.remove(transaction);
        solde -= transaction.getMontant();
    }

    //Getter
    public TypeCompte getTypeCompte() {
        return type;
    }
    public String getIban() {
        return iban;
    }
    public double getSolde() {
        return solde;
    }
    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}

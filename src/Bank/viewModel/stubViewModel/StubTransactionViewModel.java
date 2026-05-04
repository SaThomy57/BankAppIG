package Bank.viewModel.stubViewModel;

import Bank.viewModel.TransactionViewModel;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StubTransactionViewModel implements TransactionViewModel {
    private final StringProperty libelle = new SimpleStringProperty("");
    private final DoubleProperty montant = new SimpleDoubleProperty(0.0);
    private final StringProperty date = new SimpleStringProperty("");
    private final StringProperty categorie = new SimpleStringProperty("");

    @Override
    public StringProperty libelleProperty() {
        return libelle;
    }
    @Override
    public DoubleProperty montantProperty() {
        return montant;
    }
    @Override
    public StringProperty dateProperty() {
        return date;
    }
    @Override
    public StringProperty categorieProperty() {
        return categorie;
    }
}

package Bank.viewModel.stubViewModel;

import Bank.viewModel.CompteViewModel;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StubCompteViewModel implements CompteViewModel {
    private final StringProperty iban = new SimpleStringProperty("");
    private final DoubleProperty solde = new SimpleDoubleProperty(0.0);

    /*!< Implementation des méthodes définit dans l'interface 'CompteViewModel'. */
    @Override
    public StringProperty ibanProperty() {
        return iban;
    }
    @Override
    public DoubleProperty soldeProperty() {
        return solde;
    }
    @Override
    public String getType() {
        return "Courant";
    }
    @Override
    public double getSolde() {
        return solde.get();
    }
}

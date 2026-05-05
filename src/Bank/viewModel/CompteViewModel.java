package Bank.viewModel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

public interface CompteViewModel {
    // l'iban  du compte
    StringProperty ibanProperty();
    //Le solde du compte
    DoubleProperty soldeProperty();

    String getType();
    double getSolde();
}

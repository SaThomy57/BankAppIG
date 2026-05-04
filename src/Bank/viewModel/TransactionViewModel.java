package Bank.viewModel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

public interface TransactionViewModel {
    StringProperty libelleProperty();
    DoubleProperty montantProperty();
    StringProperty dateProperty();
    StringProperty categorieProperty();
}

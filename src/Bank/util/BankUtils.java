package Bank.util;

import java.util.Random;

public class BankUtils {
    /**
     * Methode qui permet de generer un iban aleatoire français
     * @return Un IBAN de 27 caractere
     */
    public static final String genererIbanFRANCE() {
        Random rdm = new Random();
        String pays = "FR";
        StringBuilder bban = new StringBuilder();
        for (int i = 0; i < 23; i++) {
            bban.append(rdm.nextInt(10));
        }
        String cleControl = String.format("%02d", rdm.nextInt(99));
        String iban = pays + cleControl + bban.toString();
        return iban.replaceAll("(.{4})", "$1 ").trim();
    }
}

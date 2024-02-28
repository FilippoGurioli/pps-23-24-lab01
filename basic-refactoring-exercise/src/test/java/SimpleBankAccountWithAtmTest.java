import org.junit.jupiter.api.BeforeEach;

import example.model.AccountHolder;
import example.model.SimpleBankAccountWithAtm;

public class SimpleBankAccountWithAtmTest extends SimpleBankAccountWithFeeTest {

    @BeforeEach
    void beforeEach() {
        var accountHolder = new AccountHolder("Mario", "Rossi", 1);
        var bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
        super.beforeEach(accountHolder, bankAccount, SimpleBankAccountWithAtm.FEE);
    }
}

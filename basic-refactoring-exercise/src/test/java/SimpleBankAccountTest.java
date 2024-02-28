import example.model.AccountHolder;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends SimpleBankAccountWithFeeTest {

    @BeforeEach
    void beforeEach() {
        var accountHolder = new AccountHolder("Mario", "Rossi", 1);
        var bankAccount = new SimpleBankAccount(accountHolder, 0);
        super.beforeEach(accountHolder, bankAccount, 0);
    }
}

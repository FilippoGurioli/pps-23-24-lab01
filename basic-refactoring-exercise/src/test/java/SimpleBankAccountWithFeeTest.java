import example.model.AccountHolder;
import example.model.BankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountWithFeeTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private double fee;

    void beforeEach(AccountHolder accountHolder, BankAccount bankAccount, double fee) {
        this.bankAccount = bankAccount;
        this.accountHolder = accountHolder;
        this.fee = fee;
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100 - this.fee, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(2, 50);
        assertEquals(100 - this.fee, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        final int numOfTransactions = 2;
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30 - numOfTransactions * this.fee, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        assertEquals(100 - this.fee, bankAccount.getBalance());
    }
}

package edu.ithaca.dragon.bank.account;

import edu.ithaca.dragon.bank.InsufficientFundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    private SavingsAccount savingsAccountWMoney;
    private SavingsAccount savingsAccountNoMoney;

    @BeforeEach
    void setup(){
        savingsAccountWMoney = new SavingsAccount("DoeJohn", 34.99);
        savingsAccountNoMoney = new SavingsAccount("DoeJane", 0);

    }


    @Test
    void getBalanceTest() {
        assertEquals(34.99, savingsAccountWMoney.getBalance(), 0.00001);
        assertEquals(0, savingsAccountNoMoney.getBalance(), 0.00001);
    }


    @Test
    void withdrawStandardTest() {
        try {
            savingsAccountWMoney.withdraw(10);
            assertEquals(24.99, savingsAccountWMoney.getBalance(), 0.00001);
            savingsAccountWMoney.withdraw(24.99);
            assertEquals(0, savingsAccountWMoney.getBalance(), 0.00001);
            savingsAccountNoMoney.withdraw(0);
        }
        catch(InsufficientFundsException e){
            fail(e);
        }
    }

    @Test
    void badWithdrawFundsTest() {
        assertThrows(IllegalArgumentException.class, ()-> savingsAccountWMoney.withdraw(-10));
        assertThrows(InsufficientFundsException.class, ()-> savingsAccountWMoney.withdraw(35));
        assertThrows(InsufficientFundsException.class, ()-> savingsAccountNoMoney.withdraw(0.01));
    }


}
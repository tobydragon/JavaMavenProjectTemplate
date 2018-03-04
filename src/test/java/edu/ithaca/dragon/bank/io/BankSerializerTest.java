package edu.ithaca.dragon.bank.io;

import edu.ithaca.dragon.bank.account.SavingsAccount;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BankSerializerTest {

    @Test
    void toJsonAndBackTest() {
        SavingsAccount toFile = new SavingsAccount("DoeJohn", 34.99);
        try {
            String fullFilename = "src/test/resources/auto/savingsAccountTest.json";
            BankSerializer.writeToJson(toFile, fullFilename);
            SavingsAccount fromFile = BankSerializer.buildSavingsAccountFromJson(fullFilename);
            assertEquals(toFile, fromFile);
        }
        catch (IOException e){
            fail(e);
        }
    }
}
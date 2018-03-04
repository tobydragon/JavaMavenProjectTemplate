package edu.ithaca.dragon.bank.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.ithaca.dragon.bank.account.SavingsAccount;

import java.io.File;
import java.io.IOException;

public class BankSerializer {

    /**
     *
     * @param savingsAccount to write to the file
     * @param filename including the (full or relative) path to the file
     * @post savingsAccount is written in json to file located at filename
     * @throws IOException if the file cannot be written (e.g. path is not found)
     */
    public static void writeToJson(SavingsAccount savingsAccount, String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(filename), savingsAccount);
    }

    /**
     *
     * @param filename to read from
     * @return SavingsAccount object read from the file
     * @throws IOException if the file cannot be read (e.g. file is not found or format is incorrect)
     */
    public static SavingsAccount buildSavingsAccountFromJson(String filename) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.readValue(new File(filename), SavingsAccount.class);
    }
}

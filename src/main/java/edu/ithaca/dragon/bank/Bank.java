package edu.ithaca.dragon.bank;

import edu.ithaca.dragon.bank.account.SavingsAccount;

import java.util.Scanner;

public class Bank {

    /**
     * a main function that creates a single account with $100, allows users to withdraw repeatedly until entering 0
     * @param args ignored, should be left blank
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        SavingsAccount acct = new SavingsAccount("Test", 100.0);
        double amt=0;
        do {
            System.out.println("Current Balance:" + acct.getBalance());
            System.out.println("Enter an amount to withdraw, or 0 to quit:");
            amt = input.nextDouble();
            try{
                acct.withdraw(amt);
            }
            catch (InsufficientFundsException e){
                System.out.println("insufficient Funds, can't withdraw");
            }
        }
        while(amt != 0);
        System.out.println("Goodbye");
    }

}

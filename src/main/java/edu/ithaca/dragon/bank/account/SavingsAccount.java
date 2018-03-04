package edu.ithaca.dragon.bank.account;

import edu.ithaca.dragon.bank.InsufficientFundsException;

public class SavingsAccount {

    private String userId;
    private double balance;

    /**
     *  default constructor to allow json import to work
     */
    private SavingsAccount() {
        userId=null;
        balance = 0;
    }

    /**
     * @param userId - the account owner
     * @param startingBalance - the initial deposit
     */
    public SavingsAccount(String userId, double startingBalance){
        this.userId = userId;
        this.balance = startingBalance;
    }

    /**
     *
     * @param amount for withdrawal
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     * @throws IllegalArgumentException if the amount is negative
     * @throws InsufficientFundsException if the amount is more than balance
     */
    public void withdraw (double amount) throws InsufficientFundsException {
        if (amount <0){
            throw new IllegalArgumentException("Cannot withdraw a negative amount.");
        }
        else if (amount > balance){
            throw new InsufficientFundsException("Cannot withdraw $" + amount + " from account with $" + balance);
        }
        else {
            balance -= amount;
        }
    }

    /**
     *
     * @param other the object to compare with the current object
     * @return true if the objects are both of the same class, and all fields are equal, false otherwise
     */
    public boolean equals(Object other){
        if(other == null){
            return false;
        }
        if(!SavingsAccount.class.isAssignableFrom(other.getClass())){
            return false;
        }
        SavingsAccount otherAccount = (SavingsAccount) other;
        if(this.userId.equals(otherAccount.userId) && this.balance == otherAccount.balance) {
            return true;
        } else {
            return false;
        }
    }

    // getters needed for json export to work

    public double getBalance(){
        return balance;
    }

    public String getUserId(){
        return userId;
    }

}

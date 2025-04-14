/*
 * Class: CMSC203
 * Instructor: 
 * Description: Extends BankAccount class to create a 
 * CheckingAccount class and a SavingsAccount class.
 * Due: 05/010/2025
 * Platform/compiler: 
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Paolo Nessim
 */

public class SavingsAccount extends BankAccount {
    private double rate = 0.025;
    private int savingsNumber = 0;
    private String accountNumber;

    public SavingsAccount(String name, double initialBalance) {
        super(name, initialBalance);
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public SavingsAccount(SavingsAccount original, double balance) {
        super(original, balance);
        this.savingsNumber = original.savingsNumber + 1;
        this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
    }


    public void postInterest() {
        double monthlyInterest = getBalance() * (rate / 12);
        deposit(monthlyInterest);
    }


    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}

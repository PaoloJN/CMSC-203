/*
 * Class: CMSC203
 * Instructor: 
 * Description: Extends BankAccount class to create a 
 CheckingAccount class and a SavingsAccount class.
 * Due: 05/010/2025
 * Platform/compiler: 
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Paolo Nessim
 */


public class CheckingAccount extends BankAccount {
    private static final double FEE = 0.15;

    public CheckingAccount(String name, double initialAmount) {
        super(name, initialAmount);        
        String newAccountNumber = getAccountNumber() + "-10";
        setAccountNumber(newAccountNumber);
    }

    @Override
    public boolean withdraw(double amount) {
        double totalAmount = amount + FEE;
        return super.withdraw(totalAmount);
    }
}

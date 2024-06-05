package atm.pkginterface;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            addTransaction("Withdraw", amount);
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposit", amount);
    }

    public boolean transfer(double amount, Account targetAccount) {
        if (withdraw(amount)) {
            targetAccount.deposit(amount);
            return true;
        }
        return false;
    }

    public void addTransaction(String type, double amount) {
        Transaction transaction = new Transaction(type, amount, balance);
        transactions.add(transaction);
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

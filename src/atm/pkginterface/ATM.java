package atm.pkginterface;

import java.util.ArrayList;
import java.util.List;

public class ATM {

    private List<User> users;
    User currentUser;

    public ATM() {
        this.users = new ArrayList<>();
        this.currentUser = null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean authenticateUser(String userId, int pin) {
        for (User user : users) {
            if (user.getUserId().equals(userId) && user.verifyPin(pin)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public String performWithdrawal(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null && account.withdraw(amount)) {
            return "Withdrawal successful.";
        }
        return "Insufficient balance.";
    }

    public String performDeposit(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            return "Deposit successful.";
        }
        return "Account not found.";
    }

    public String performTransfer(String sourceAccountNumber, String targetAccountNumber, double amount) {
        Account sourceAccount = getAccount(sourceAccountNumber);
        Account targetAccount = getAccount(targetAccountNumber);
        if (sourceAccount != null && targetAccount != null) {
            if (sourceAccount.transfer(amount, targetAccount)) {
                return "Transfer successful.";
            }
            return "Insufficient balance.";
        }
        return "Account not found.";
    }

    public String showTransactionHistory(String accountNumber) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            StringBuilder history = new StringBuilder();
            for (Transaction transaction : account.getTransactionHistory()) {
                history.append(transaction.toString()).append("\n");
            }
            return history.toString();
        }
        return "Account not found.";
    }

    private Account getAccount(String accountNumber) {
        for (Account account : currentUser.getAccounts()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void logout() {
        currentUser = null;
    }
}

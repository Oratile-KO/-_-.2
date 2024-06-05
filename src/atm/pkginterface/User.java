package atm.pkginterface;

import java.util.ArrayList;
import java.util.List;

public class User {

    //Declaring the user variables
    private String userID;
    private int pin;
    private List<Account> accounts;

    public User(String userID, int pin) {
        this.userID = userID;
        this.pin = pin;
        this.accounts = new ArrayList<>();
    }

    public boolean verifyPin(int pin) {
        return this.pin == pin;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getUserId() {
        return userID;
    }
}

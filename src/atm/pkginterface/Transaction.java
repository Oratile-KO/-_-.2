package atm.pkginterface;

import java.util.Date;

public class Transaction {

    private long transactionId;
    private String type;
    private double amount;
    private Date timestamp;
    private double balanceAfter;

    public Transaction(String type, double amount, double balanceAfter) {
        this.transactionId = new Date().getTime();
        this.type = type;
        this.amount = amount;
        this.timestamp = new Date();
        this.balanceAfter = balanceAfter;
    }

    @Override
    public String toString() {
        return timestamp + " - " + type + " - " + amount + " - Balance after: " + balanceAfter;
    }
}

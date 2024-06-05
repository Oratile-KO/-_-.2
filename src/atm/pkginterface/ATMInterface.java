package atm.pkginterface;

public class ATMInterface {

    public static void main(String[] args) {
        // TODO code application logic here
        ATM atm = new ATM();

        User user1 = new User("user1", 1234);  // Change pin to int
        Account account1 = new Account("acc1", 5000);
        user1.addAccount(account1);

        User user2 = new User("user2", 5678);  // Change pin to int
        Account account2 = new Account("acc2", 3000);
        user2.addAccount(account2);

        atm.addUser(user1);
        atm.addUser(user2);

        Interface atmInterface = new Interface(atm);
        atmInterface.start();
    }
}

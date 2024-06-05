package atm.pkginterface;

import java.util.Scanner;

public class Interface {

    private ATM atm;

    public Interface(ATM atm) {
        this.atm = atm;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM");
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        if (atm.authenticateUser(userId, pin)) {
            showMainMenu(scanner);
        } else {
            System.out.println("Authentication failed. Please try again.");
        }
    }

    private void showMainMenu(Scanner scanner) {
        while (atm.currentUser != null) {
            System.out.println("\n1. Transaction history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Select an option: ");
            String option = scanner.nextLine();
            handleOption(option, scanner);
        }
    }

    private void handleOption(String option, Scanner scanner) {
        switch (option) {
            case "1" -> {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.nextLine();
                System.out.println(atm.showTransactionHistory(accountNumber));
            }
            case "2" -> {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.nextLine();
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                System.out.println(atm.performWithdrawal(accountNumber, withdrawAmount));
            }
            case "3" -> {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.nextLine();
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                System.out.println(atm.performDeposit(accountNumber, depositAmount));
            }
            case "4" -> {
                System.out.print("Enter source account number: ");
                String sourceAccountNumber = scanner.nextLine();
                System.out.print("Enter target account number: ");
                String targetAccountNumber = scanner.nextLine();
                System.out.print("Enter amount to transfer: ");
                double transferAmount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                System.out.println(atm.performTransfer(sourceAccountNumber, targetAccountNumber, transferAmount));
            }
            case "5" -> {
                atm.logout();
                System.out.println("You have been logged out.");
            }
            default ->
                System.out.println("Invalid option. Please try again.");
        }
    }
}

package Mini;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        }
    }

    public String toString() {
        return "Account Number: " + accountNumber + ", Account Holder: " + accountHolderName + ", Balance: " + balance;
    }
}

public class BankManagementSystem {
    private Map<String, BankAccount> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void createAccount() {
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter account holder name:");
        String accountHolderName = scanner.nextLine();
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists.");
        } else {
            BankAccount account = new BankAccount(accountNumber, accountHolderName);
            accounts.put(accountNumber, account);
            System.out.println("Account created successfully!");
        }
    }

    public void deposit() {
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found.");
        } else {
            System.out.println("Enter amount to deposit:");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            accounts.get(accountNumber).deposit(amount);
        }
    }

    public void withdraw() {
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found.");
        } else {
            System.out.println("Enter amount to withdraw:");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            accounts.get(accountNumber).withdraw(amount);
        }
    }

    public void checkBalance() {
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found.");
        } else {
            System.out.println("Current balance: " + accounts.get(accountNumber).getBalance());
        }
    }

    public static void main(String[] args) {
        BankManagementSystem system = new BankManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===Bank Account Management===\nMenu:");
            System.out.println("1. Create an account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check balance");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    system.createAccount();
                    break;
                case 2:
                    system.deposit();
                    break;
                case 3:
                    system.withdraw();
                    break;
                case 4:
                    system.checkBalance();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}


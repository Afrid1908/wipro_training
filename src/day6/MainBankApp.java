package day6;

import java.util.Scanner;

interface Bank {
    double getBalance();
    void deposit(double amount);
    void withdraw(double amount);

    default void displayAccountType() {
        System.out.println("Account Type: Generic Bank Account");
    }

    default void executeTransaction(String type, double amount) {
        if (!Bank.isValid(amount)) {
            System.out.println("Invalid amount: " + amount);
            return;
        }

        switch (type.toUpperCase()) {
            case "DEPOSIT":
                deposit(amount);
                System.out.println("Deposited " + amount + ". New balance: " + getBalance());
                break;
            case "WITHDRAW":
                withdraw(amount);
                System.out.println("Withdrew " + amount + ". New balance: " + getBalance());
                break;
            default:
                System.out.println("Unknown transaction type: " + type);
        }
    }

    static boolean isValid(double amount) {
        return amount > 0;
    }
}

class SavingsAccount implements Bank {
    private double balance;

    public SavingsAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds to withdraw " + amount);
        }
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}

public class MainBankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();

        Bank account = new SavingsAccount(initialBalance);
        account.displayAccountType();

        boolean continueTransactions = true;

        while (continueTransactions) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.executeTransaction("deposit", depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.executeTransaction("withdraw", withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 4:
                    continueTransactions = false;
                    System.out.println("Exiting. Final Balance: " + account.getBalance());
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1-4.");
            }
        }

       
    }
}

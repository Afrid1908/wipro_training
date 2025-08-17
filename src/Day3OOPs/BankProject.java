package Day3OOPs;


class BankAccount {
	   private String accountHolder;
	   private double balance;
	   // Constructor- Initialize the Objects
	   public BankAccount(String accountHolder, double initialBalance) {
	       this.accountHolder = accountHolder;
	       this.balance = initialBalance;
	   }
	   // Deposit method
	   public void deposit(double amount) {
	       balance += amount;
	       System.out.println(amount + " deposited. New Balance: " + balance);
	   }
	   // Withdraw method
	   public void withdraw(double amount) {
	       if (amount > balance) {
	           System.out.println("Insufficient balance.");
	       } else {
	           balance -= amount;
	           System.out.println(amount + " withdrawn. Remaining Balance: " + balance);
	       }
	   }
	   // Display account details
	   public void displayDetails() {
	       System.out.println("Account Holder: " + accountHolder);
	       System.out.println("Balance: " + balance);
	   }
	}


public class BankProject {
	
	public static void main(String[] args) {
	       BankAccount account = new BankAccount("Afrid", 1000);
	       account.deposit(500);
	       account.withdraw(300);
	       account.displayDetails();
	   }


}

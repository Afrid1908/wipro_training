package day4;

interface EcommPayment {
	void makePayment();	
}


abstract class PaymentSystem implements EcommPayment {

double amount ;
	
	PaymentSystem(double amount)
	{
		this.amount = amount ;
	}
	
	void showSuccessMessage()
	{
		System.out.println("Payment is SuccessFull "+amount);
	}

}

class NetBankingPayment extends PaymentSystem
{
	 NetBankingPayment(double amount)
	 {
		super(amount) ;
	}
	
	 public void makePayment()
	{
		System.out.println("Net Banking Payment is Done...");
		showSuccessMessage();
	}
}

class CreditCardPayment extends PaymentSystem
{
	CreditCardPayment(double amount)
	{
		super(amount) ;
		
	}
	
	public void makePayment()
	{
		System.out.println("Credit Card payment is Done...");
	}
}

class DebitCardPayment extends PaymentSystem
{
	DebitCardPayment(double amount)
	{
		super(amount) ;
	}
	
	public void makePayment()
	{
		System.out.println("Debit Card Payment is Done...");
		showSuccessMessage();
	}
}




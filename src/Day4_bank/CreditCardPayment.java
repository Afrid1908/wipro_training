package Day4_bank;

class CreditCardPayment extends Payment
{
	CreditCardPayment(double amount)
	{
		super(amount) ;
		
	}
	
	void makePayment()
	{
		System.out.println("Credit Card payment is Done...");
	}
}

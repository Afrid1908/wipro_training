package Day4_bank;

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

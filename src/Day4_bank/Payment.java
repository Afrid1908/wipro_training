package Day4_bank;

abstract class Payment
{
	double amount ;
	
	Payment(double amount)
	{
		this.amount = amount ;
	}
	
	abstract void makePayment() ;
	
	void showSuccessMessage()
	{
		System.out.println("Payment successfull "+amount);
	}
	
}



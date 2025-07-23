package Day4_bank;

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

package Day4_bank;

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


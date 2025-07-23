package Day4_bank;

class UpiPayment extends Payment
{
	 UpiPayment(double amount)
	 {
		super(amount) ;
	}
	
	 void makePayment()
	 {
		 System.out.println("Upi payment is Done...");
	 }
}
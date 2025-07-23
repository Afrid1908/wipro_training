package Day4_bank;

public class PaymentAppMain {

	public static void main(String[] args)
	{
		Payment py = new CreditCardPayment(45000) ;
		py.makePayment();
		System.out.println("Credit Card Payment Process is Completed ");
		
		Payment py2 = new UpiPayment(30000) ;
		py2.makePayment();
		System.out.println("Upi Payment Process is Completed ");
	}
}


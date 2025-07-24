package day4;

public class EcommPayment_Main {
	
	public static void main(String[] args)
		{
			PaymentSystem ep = new DebitCardPayment(10000);
			ep.makePayment();
			
			
			System.out.println("--------------------------");
			
			PaymentSystem ep2 = new NetBankingPayment(55000);
			ep2.makePayment();		
			
			
			System.out.println("--------------------------");

			PaymentSystem ep3 = new CreditCardPayment(40000);
			ep3.makePayment();
			
	    }
}

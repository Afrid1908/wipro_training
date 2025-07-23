package Day4_bank;

public class MainPaymentSystem {
public static void main(String[] args)
	{
		PaymentSystem ep = new DebitCardPayment(34000) ;
		ep.makePayment();
		
		
		System.out.println();
		
		PaymentSystem ep2 = new NetBankingPayment(55000) ;
		ep2.makePayment();		
		
    }
}

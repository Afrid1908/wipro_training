package day4;

public class Payment_Main {

	public static void main(String[] args)
	{	
		Payment py2 = new UpiPayment(30000) ;
		py2.makePayment();
		System.out.println("Upi Payment Process is Completed ");
	}
}


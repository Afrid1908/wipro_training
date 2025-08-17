package day7;

import java.util.Scanner;

public class ArithmeticExceptionExample {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first number: ");
		int num1 = sc.nextInt();
		System.out.println("Enter second number: ");
		int num2 = sc.nextInt();
		int res;
		
		try {
			res=num1/num2;
			System.out.println("Result: "+res);
		}catch(Exception e) {
			System.err.println("Some Exception occured");
			e.printStackTrace();
		}
		finally {
			System.out.println("Execution complete...");
		}
	}

}

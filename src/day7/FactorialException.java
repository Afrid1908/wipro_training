package day7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FactorialException {
	static int factorial(int num) {
		int fact=1;
		for(int i=1;i<=num;i++) {
			fact = fact*i;
		}
		return fact;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter nummber to find factorial: \n");
			int num = sc.nextInt();
			if(num < 0) {
				throw new IllegalArgumentException("Number must be positive");
			}
			int result = factorial(num);
			System.out.println("Factorial of "+num+" is: "+result);
		}catch(InputMismatchException e) {
			System.err.println("Please enter valid input!!!");
			e.printStackTrace();
		}catch(IllegalArgumentException e) {
			System.err.println("Error "+e.getMessage());
		}
				
	}

}

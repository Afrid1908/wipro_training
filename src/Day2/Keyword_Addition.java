package Day2;

import java.util.Scanner;

public class Keyword_Addition {
	 public static void main(String[] args) { // keywords: public, static, void
	        Scanner sc = new Scanner(System.in);   // keywords: new, class name Scanner
	        System.out.print("Enter first number: ");
	        int a = sc.nextInt();   // keyword: int
	        System.out.print("Enter second number: ");
	        int b = sc.nextInt();   // keyword: int
	        int sum = a + b;        // keyword: int
	        System.out.println("Sum = " + sum);
	        sc.close();             // closes the scanner
	    }
}

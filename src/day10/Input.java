package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Input {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a number");
//		int num = System.in.read();
//		System.out.println(num);		//it will print ascii value
		
//		InputStreamReader in = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(in);
//		
//		int num = Integer.parseInt(br.readLine());
//		System.out.println(num);
//		in.close();
//		br.close();
		
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println(a);
	}

}

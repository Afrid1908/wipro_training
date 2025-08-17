package day5;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambadaConsumerInterface {

	public static void main(String[] args) {
	 ArrayList<Integer> a1= new ArrayList<>();
	 a1.add(10);
	 a1.add(20);
	 a1.add(30);
	 a1.add(40);
	 a1.add(50);
	 
	 Consumer<Integer> myMethod = (n) ->{System.out.println(n);};
	 a1.forEach(myMethod);

	}

}

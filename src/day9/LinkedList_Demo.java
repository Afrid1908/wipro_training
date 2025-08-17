package day9;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedList_Demo {

	public static void main(String[] args) {
		LinkedList<String> countries = new LinkedList<>();
		countries.add("India");
		countries.add("Russia");
		countries.add("UK");
		countries.add("Japan");
		countries.add("France");
		
		countries.addFirst("UAE");
		countries.addLast("China");
		
		System.out.println(countries);
		
		Collections.sort(countries);
		System.out.println("Sorted list: "+countries);

		countries.removeFirst();
		System.out.println("After removing first: "+countries);
		countries.removeLast();
		System.out.println("After removing last: "+countries);

		
		System.out.println("Getting first: "+countries.getFirst());
		System.out.println("Getting last: "+countries.getLast());
		
		
	}

}

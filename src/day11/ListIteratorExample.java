package day11;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(List.of(10,20,30,40,50));
		ListIterator<Integer> itr = list.listIterator();
		
		System.out.println("Forward");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("\nBackward");
		while(itr.hasPrevious()) {
			System.out.println(itr.previous());
		}		
	}

}

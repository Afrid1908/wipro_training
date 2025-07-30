package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator_Int {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(45);
		list.add(20);
		list.add(54);
		list.add(38);
		list.add(12);
		System.out.println("Before sorting list: "+list);

		Comparator<Integer> comp = new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		};
		Collections.sort(list,comp);
		
		System.out.println("Sorted list: "+list);
	}
}

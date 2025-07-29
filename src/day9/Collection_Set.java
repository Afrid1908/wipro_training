package day9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Collection_Set {

	public static void main(String[] args) {
		Set<Integer> data = new HashSet<>();
		data.add(45);
		data.add(32);
		data.add(12);
		data.add(65);
		data.add(54);
		data.add(65);
		System.out.println(data);
		
		Iterator<Integer> itr = data.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}

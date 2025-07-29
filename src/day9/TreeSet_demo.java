package day9;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSet_demo {

	public static void main(String[] args) {
		Set<Integer>st = new TreeSet<>();
		st.add(50);
		st.add(10);
		st.add(30);
		st.add(20);
		st.add(40);
		
		//it maintains the natural sorting order
		System.out.println(st);
		
	}

}

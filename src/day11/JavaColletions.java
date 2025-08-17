package day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaColletions {

	public static void main(String[] args) {
		List<String> course = new ArrayList<String>();
		course.add("Java");
		course.add("Python");
		course.add("C#");
		course.add("JavaScript");
		course.add("Java");
		System.err.println("List can have duplicate elements & Maintains insertion order");
		for(String c1 : course) {
			System.out.println(c1);
		}
		
		Set<String> course1 = new HashSet<>();
		course1.add("Java");
		course1.add("Python");
		course1.add("MySQL");
		course1.add("C#");
		course1.add("Java");
		System.err.println("\nSet can not have duplicate elements & Maintains natural sorting order");
		for(String c2 : course1) {
			System.out.println(c2);
		}

		Map<Integer,String> course3 = new HashMap<>();
		course3.put(110, "Java");
		course3.put(115, "Python");
		course3.put(111, "MySql");
		course3.put(114, "C#");
		course3.put(110, "Java");
		course3.put(112, "Java");
		System.err.println("\nMap can have duplicate values, but not duplicate key");
		for(Integer i : course3.keySet()) {
			System.out.println(i+" = "+course3.get(i));
		}
		
	}

}

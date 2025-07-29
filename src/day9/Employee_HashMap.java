package day9;

import java.util.HashMap;
import java.util.Map;

public class Employee_HashMap {

	public static void main(String[] args) {
		Map<Integer, String> employee = new HashMap<>();
		employee.put(101, "John");
		employee.put(102, "Kane");
		employee.put(103, "Mickel");
		employee.put(104, "Nile");
		employee.put(105, "Alice");
		System.out.println("EmpId "+"Name ");
		
		for(Map.Entry<Integer, String> entry : employee.entrySet()) {
			System.out.println(" "+entry.getKey()+"  "+entry.getValue());
		}
	}
}

//Map.Entry ->it represents single key,value pair/object in Map, interface works like iterator useful for both <key,value>
//entrySet() ->is method in Map that returns set of all objects in Map.Entry i.e all <key,value> pairs
package day11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee{
	private int id;
	private String name;
	
	public Employee(int id, String name) {
		this.id=id;
		this.name=name;
	}
	public Employee() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId() {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName() {
		this.name=name;
	}
	
	public String toString() {
		return id +" : "+name;
	}
}
public class SortByLambada {

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee(105,"Naman"));
		emp.add(new Employee(102,"Dinesh"));
		emp.add(new Employee(104,"Aman"));
		emp.add(new Employee(101,"Rohit"));
		emp.add(new Employee(103,"Mahesh"));
		
		System.out.println("Before sorting");
		for(Employee e : emp) {
			System.out.println(e);
		}
		
		emp.sort(Comparator.comparing(Employee::getId).thenComparing(Employee::getName));
		
		System.out.println("\nAfter sorting using lambada expression");
		for(Employee e1 : emp) {
			System.out.println(e1);
		}
	}

}

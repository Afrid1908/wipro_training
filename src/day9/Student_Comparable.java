package day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student_Comparable implements Comparable<Student_Comparable> {

	private int id;
	private String name;
	public Student_Comparable(int id, String name) {
		this.id=id;
		this.name=name;
	}
	@Override
	public int compareTo(Student_Comparable other) {
		return this.id - other.id;
	}
	
	public String toString() {
		return id +" : "+name;
	}

	public static void main(String[] args) {
		List<Student_Comparable> s1 = new ArrayList<>();
		s1.add(new Student_Comparable(3,"Jay"));
		s1.add(new Student_Comparable(2,"Roy"));
		s1.add(new Student_Comparable(5,"Harry"));
		s1.add(new Student_Comparable(1,"Alice"));
		s1.add(new Student_Comparable(4,"Jason"));
		
		Collections.sort(s1);	//this sort method internally uses the compareTo method for natural order
		System.out.println(s1);
		
	}

	

}

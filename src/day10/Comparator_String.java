package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparator<Student>{
	private int rollno;
	private String name;
	
	public Student(int rollno, String name) {
		this.rollno=rollno;
		this.name=name;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Student[rollno: "+rollno+", name: "+name+ "]";
	}

	@Override
	public int compare(Student s1, Student s2) {
		//compare & sort rollno in ascending order
		return s1.rollno - s2.rollno;
		
		//compare & sort rollno in descending order
//		return s2.rollno - s1.rollno;
	}
}

public class Comparator_String {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(105,"Naman"));
		students.add(new Student(101,"Raj"));
		students.add(new Student(104,"Amit"));
		students.add(new Student(103,"Sam"));
		students.add(new Student(102,"Joy"));
		
		System.out.println("list before sort");
		for(Student std : students) {
			System.out.println(std);
		}
		
		Collections.sort(students, new Student());
		
		System.out.println("\nlist after sort");
		for(Student std : students) {
			System.out.println(std);
		}
	}

}

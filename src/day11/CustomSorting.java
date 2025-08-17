package day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
	private String name;
	private Double marks;
	
	public Student(String name, Double marks) {
		this.name=name;
		this.marks=marks;
	}
	public Student() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMarks() {
		return marks;
	}
	public void setMarks(Double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + "]";
	}
	
}

class MultipleSorting implements Comparator<Student>{
	//first comparing by name, then marks
	@Override
	public int compare(Student s1, Student s2) {
		//compare by name
		int NameCompare = s1.getName().compareTo(s2.getName());
		
		//if names are same, then compare by marks 
		Double MarksCompare = (double) s1.getMarks().compareTo(s2.getMarks());
		
		return (int) ((NameCompare == 0) ? MarksCompare : NameCompare);
	}
	
}
public class CustomSorting {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Joy",86.55));
		students.add(new Student("Adam",80.50));
		students.add(new Student("Sam",75.90));
		students.add(new Student("Joy",90.10));
		students.add(new Student("Alex",88.40));
		
		System.out.println("Original list: ");
		for(Student s : students) {
			System.out.println(s);
		}
		
		Collections.sort(students,new MultipleSorting());
		System.out.println("\nAfter sorting:");
		for(Student st : students) {
			System.out.println(st);
		}
	}

}

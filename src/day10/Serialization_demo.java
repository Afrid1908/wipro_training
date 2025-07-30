package day10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student1 implements Serializable{
	private int rollno;
	private String name;
	
	public Student1(int rollno, String name) {
		super();
		this.rollno = rollno;
		this.name = name;
	}
	public Student1() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + "]";
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
public class Serialization_demo {

	public static void main(String[] args) throws IOException {
		Student1 std1 = new Student1();
		std1.setRollno(10);
		std1.setName("Afrid");
		
		//Serialization demo
		try{
			FileOutputStream fileOut = new FileOutputStream("C://Users/Admin/Desktop/javafile.txt");
			ObjectOutputStream output = new ObjectOutputStream(fileOut);
			output.writeObject(std1);
			
			System.out.println("Serialiazed data saved in file");
		}catch(IOException e) {
			e.printStackTrace();
		}	
				
		//Deserialization demo
//		try {
//			FileInputStream fileIn = new FileInputStream("C://Users/Admin/Desktop/javafile.txt");
//			ObjectInputStream input = new ObjectInputStream(fileIn);
//			Student1 std =(Student1) input.readObject();
//            System.out.println("Deserialized student data: " + std);
//
//		}catch(IOException |ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
}

package day7;

import java.io.File;

public class CreateNewFile {

	public static void main(String[] args) {
		try {
			File f1 = new File("C://Users/Admin/Desktop/javafile.txt");
			if(f1.createNewFile()) {
				System.out.println(f1.getName()+" is created succesfully");
			}else {
				System.out.println("File Already Exists!!!");
			}
		}catch(Exception e) {
			System.out.println("Some eror occurred");
			e.printStackTrace();
		}finally{
			System.out.println("...Execution completed...");
		}
	}

}

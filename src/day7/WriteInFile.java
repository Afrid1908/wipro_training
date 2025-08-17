package day7;

import java.io.FileWriter;
import java.io.IOException;

public class WriteInFile {

	public static void main(String[] args) {

		try {
			FileWriter wt = new FileWriter("C://Users/Admin/Desktop/javafile.txt");
			wt.write("Learning java file handling");
			wt.close();
			System.out.println("------------------");
			System.out.println("Content Written to the file");
		}catch(IOException e) {
			System.out.println("some error occurred...");
		}finally {
			System.out.println("Execution completed...");
		}
	}

}

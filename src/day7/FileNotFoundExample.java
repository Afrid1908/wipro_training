package day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileNotFoundExample {

	public static void main(String[] args) {
		File f1 = new File("C://Users/Admin/Desktop/fileread.txt");

		try {
			
			BufferedReader b1 = new BufferedReader(new FileReader(f1));
			String line = b1.readLine();
			System.out.println("-------------Start Reading File-------------");

		while(line != null) {
			System.out.println("File content: "+line);
			line = b1.readLine();
		}
		    b1.close();
		} catch(FileNotFoundException e) {
			System.err.println("Cannot find the specified file!!!");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.err.println("I/O error occured while reading file!!!");
			e.printStackTrace();
		}finally {
			System.out.println("-------------Execution completed-------------");
		}
		
		
	}

}

package day12;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {

	public static void main(String[] args) throws FileNotFoundException {
		//Write in file
//		try {
//			FileWriter wt = new FileWriter("C://Users/Admin/Desktop/javafile.txt");
//			wt.write("Writing content to file\n");
//			wt.write("Hello, file handling in java");
//			System.out.println("Content written to file...");
//			wt.close();
//		}catch(IOException e) {
//			System.out.println("Error occured while writing to file");
//			e.printStackTrace();
//		}
		
		//Read from file
		try {
			FileReader fd = new FileReader("C://Users/Admin/Desktop/javafile.txt");
			int read;
			while((read = fd.read()) != -1) {
				System.out.print((char) read);
			}
		}catch(IOException e) {
			System.out.println("Error occurred while reading file");
			e.printStackTrace();
		}
		
	}

}

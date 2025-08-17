package day10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadHtmlFile {

	public static void main(String[] args) throws FileNotFoundException {
		//to append the string 
		StringBuilder sb = new StringBuilder();
		
		//reading html file
		FileReader fread = new FileReader("C://Users/Admin/Desktop/simple.html");
		try {
			BufferedReader bread = new BufferedReader(fread);
			String val;
			
			//reading string till we get null
			while((val = bread.readLine()) != null) {
				sb.append(val);
			}
			
			//converting into string
			String result = sb.toString();
			System.out.println(result);
			
			bread.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

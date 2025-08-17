package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileCompare {

	public static void main(String[] args) {
		try {
			BufferedReader r1 = new BufferedReader(new FileReader("C://Users/Admin/Desktop/file1.txt/"));
			BufferedReader r2 = new BufferedReader(new FileReader("C://Users/Admin/Desktop/file2.txt/"));
			
			String line1 = r1.readLine();
//			System.out.println(line1);
			String line2 = r2.readLine();
			int lineNum = 1;
			boolean isEqual=true;
			
			while(line1 != null || line2 != null) {
				if(line1 == null || line2 == null) {
					isEqual=false;
					break;
				}else if(! line1.equalsIgnoreCase(line2)) {
					isEqual=false;
					break;
				}
				line1 = r1.readLine();
				line2 = r2.readLine();
				lineNum++;
			}
			if(isEqual) {
				System.out.println("Both files have same content");
				System.out.println("first file has: "+line1+", second file has: "+line2);

			}else {
				System.out.println("files have different content");
				System.out.println("There is difference in one file at line no: "+lineNum);
				System.out.println("first file has: "+line1+", second file has: "+line2);
			}
			r1.close();
			r2.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

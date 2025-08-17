package day9;

public class WrapperExample {

	public static void main(String[] args) {
		int a=12;
		// Converting primitive datatype into object that is AutoBoxing
		Integer i = a; 
		
		//object to primitive datatype is called  unboxing
		//int b = i.intValue(); 
		//int b = i;
		
		System.out.println(i);
	}

}

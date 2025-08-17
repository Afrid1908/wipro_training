package day9;

public class WrapperDouble {

	public static void main(String[] args) {
		double d = 45.67; // primitive double

        // Autoboxing: converting primitive double to Double object
        Double doubleObj = d;

        // Unboxing: converting Double object back to primitive double
//        double d2 = doubleObj; // implicit unboxing

        System.out.println(doubleObj);
	}

}

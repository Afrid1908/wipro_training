package day9;

public class WrapperFloat {

	public static void main(String[] args) {
		float f = 12.5f; // primitive float

        // Autoboxing: converting primitive float to Float object
        Float floatObj = f;

        // Unboxing: converting Float object back to primitive float
//        float f2 = floatObj; 

        System.out.println(floatObj);
	}

}

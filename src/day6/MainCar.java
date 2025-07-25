package day6;

interface Vehicle {

    void start();

    default void fuelType() {
        System.out.println("Default Fuel Type: Petrol");
    }

    static void serviceInfo() {
        System.out.println("All vehicles must need fuel...");
    }
}

class Car implements Vehicle {

	//It is abstract method need to be implement
    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    //It is default method
    @Override
    public void fuelType() {
        System.out.println("Car uses Diesel.");
    }
}

public class MainCar {

	public static void main(String[] args) {

		 Car myCar = new Car();

		 myCar.start();          
	     myCar.fuelType();        

	     //To call static method we can directly call by name of that interface
	     Vehicle.serviceInfo();  
	}

}

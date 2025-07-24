package day4;

abstract class Vehicle {
	abstract void brand();
	abstract void speed();
}

class Car extends Vehicle{

	@Override
	void brand() {
		// TODO Auto-generated method stub
		System.out.println("Car brand is : TATA");
	}

	@Override
	void speed() {
		// TODO Auto-generated method stub
		System.out.println("Car speed is : 50km/hr");
	}
	
}

class Bike extends Vehicle{

	@Override
	void brand() {
		// TODO Auto-generated method stub
		System.out.println("Bike brand is : Honda");
	}

	@Override
	void speed() {
		// TODO Auto-generated method stub
		System.out.println("Bike speed is : 30km/hr");
	}
	
}



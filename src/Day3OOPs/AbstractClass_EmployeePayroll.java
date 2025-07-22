package Day3OOPs;

abstract class Employee1 {
    String name;
    int empId;

    public Employee1(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }

    // Abstract method
    abstract double calculateSalary();

    // Common method
    public void display() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + name);
    }
}

class FullTimeEmployee extends Employee1 {
    double monthlySalary;

    public FullTimeEmployee(String name, int empId, double monthlySalary) {
        super(name, empId);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee1 {
    int hoursWorked;
    double ratePerHour;

    public PartTimeEmployee(String name, int empId, int hoursWorked, double ratePerHour) {
        super(name, empId);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * ratePerHour;
    }
}


public class AbstractClass_EmployeePayroll {

	 public static void main(String[] args) {
	        Employee1 e1 = new FullTimeEmployee("Afrid", 101, 50000);
	        Employee1 e2 = new PartTimeEmployee("Varun", 102, 80, 300);

	        e1.display();
	        System.out.println("Salary: ₹" + e1.calculateSalary());

	        System.out.println();

	        e2.display();
	        System.out.println("Salary: ₹" + e2.calculateSalary());
	    }

}

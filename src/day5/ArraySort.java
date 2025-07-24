package day5;

import java.util.Scanner;
import java.util.Arrays;


abstract class EmployeeManager {
    public String[] employeeNames;
    public int count;

    public abstract void inputNames();
    public abstract void sortNames();
    public abstract void displayNames();
}

public class ArraySort extends EmployeeManager {

	@Override
	public void inputNames() {
	    Scanner sc = new Scanner(System.in);

	    employeeNames = new String[5];

	    System.out.println("Enter the names of 5 employees:");
	    for (int i = 0; i < 5; i++) {
	        System.out.print("Employee " + (i + 1) + ": ");
	        employeeNames[i] = sc.nextLine();
	    }
	}

    @Override
    public void sortNames() {
        Arrays.sort(employeeNames);
    }

    @Override
    public void displayNames() {
        System.out.println("\nSorted employee names:");
        for (String name : employeeNames) {
            System.out.println(name);
        }
    }

   
    public static void main(String[] args) {
        ArraySort sort = new ArraySort();
        sort.inputNames();
        sort.sortNames();
        sort.displayNames();
    }
}

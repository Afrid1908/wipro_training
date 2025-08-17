package day5;

import java.util.Scanner;


abstract class RentCalculator {
 protected double baseRent;
 protected double utilities;
 protected double maintenance;

 public abstract void inputDetails(Scanner sc);
 public abstract void calculateTotalRent();
}

class HouseRentCalculator extends RentCalculator {
    @Override
    public void inputDetails(Scanner sc) {
        System.out.println("\n--- House Rent Details ---");
        System.out.print("Enter base rent: ");
        baseRent = sc.nextDouble();

        System.out.print("Enter utilities cost: ");
        utilities = sc.nextDouble();

        System.out.print("Enter maintenance cost: ");
        maintenance = sc.nextDouble();
    }

    @Override
    public void calculateTotalRent() {
        double total = baseRent + utilities + maintenance;
        System.out.println("Total House Rent: " + total);
    }
}

class ApartmentRentCalculator extends RentCalculator {
    @Override
    public void inputDetails(Scanner sc) {
        System.out.println("\n--- Apartment Rent Details ---");
        System.out.print("Enter base rent: ");
        baseRent = sc.nextDouble();

        System.out.print("Enter utilities cost: ");
        utilities = sc.nextDouble();

        System.out.print("Enter maintenance cost: ");
        maintenance = sc.nextDouble();
    }

    @Override
    public void calculateTotalRent() {
        double total = baseRent + utilities + maintenance;
        System.out.println("Total Apartment Rent: " + total);
    }
}


public class RealEstateSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose property type:\n1. House\n2. Apartment");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = sc.nextInt();

        RentCalculator calculator;

        switch (choice) {
            case 1:
                calculator = new HouseRentCalculator();
                break;
            case 2:
                calculator = new ApartmentRentCalculator();
                break;
            default:
                System.out.println("Invalid choice!!!....");
                sc.close();
                return;
        }

        calculator.inputDetails(sc);
        calculator.calculateTotalRent();

        sc.close();
    }
}

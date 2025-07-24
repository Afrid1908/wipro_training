package day5;

import java.util.*;

class Property {
    String type;
    String location;
    double price;

    public Property(String type, String location, double price) {
        this.type = type;
        this.location = location;
        this.price = price;
    }

    @Override
    public String toString() {
        return type + " in " + location + " - " + price;
    }
}

public class LambadaExample {
    public static void main(String[] args) {
        List<Property> properties = new ArrayList<>();
        properties.add(new Property("Apartment", "New Delhi", 100000));
        properties.add(new Property("House", "Mumbai", 95000));
        properties.add(new Property("Villa", "Pune", 90000));
        properties.add(new Property("Studio", "Bangalore", 98000));
        properties.add(new Property("Flat", "Kolkata", 70000));

        // Sort by Location
        System.out.println("Sorted by Location:");
        properties.sort((p1, p2) -> p1.location.compareTo(p2.location));
        properties.forEach(System.out::println);

        // Sort by Price
        System.out.println("\nSorted by Price:");
        properties.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        properties.forEach(System.out::println);
    }
}




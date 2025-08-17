package day9;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_Demo {

	public static void main(String[] args) {
		ArrayList<String> fruits = new ArrayList<>();
		fruits.add("Apple");
		fruits.add("Mango");
		fruits.add("Banana");
		fruits.add("Orange");
		fruits.add("Watermelon");
		
		System.out.println(fruits);
		
		//Access elements based on index
		System.out.println("\nAccessing Element by index");
		System.out.println(fruits.get(3));
		
		//update elements
		System.out.println("\nUpdating Element");
		fruits.set(1, "Grapes");
		System.out.println(fruits);
		
		System.out.println("\nRemoving Element");
		fruits.remove(4);
		System.out.println(fruits);
		
		System.out.println(fruits.size()+"\n");
		
		//iterate arraylist
		for(String ft : fruits) {
			System.out.println(ft);
		}
		
		//sort the list
		Collections.sort(fruits);
		System.out.println("\nSorted list: "+fruits);


		ArrayList<Integer> num = new ArrayList<>();
		num.add(50);
		num.add(35);
		num.add(44);
		num.add(10);
		num.add(25);
		
		Collections.sort(num);
		System.out.print("Sorted list: ");
		for(Integer i : num) {
			System.out.print(i+" ");
		}
		
	}

}

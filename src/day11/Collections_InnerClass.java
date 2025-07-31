package day11;

import java.util.ArrayList;
import java.util.List;

public class Collections_InnerClass {

	class ItemList{
		private String name;
		private int quantity;
		private double price;
		
		public ItemList(String name,int quantity,double price){
			this.name=name;
			this.quantity=quantity;
			this.price=price;
		}
		public ItemList() {
			
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "ItemList [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
		}
		
	}
	public static void main(String[] args) {
		List<ItemList> item = new ArrayList<>();
		item.add(new Collections_InnerClass().new ItemList("Notebook",5,100));
		item.add(new Collections_InnerClass().new ItemList("Pen",20,80));
		item.add(new Collections_InnerClass().new ItemList("Compass",10,200));
		item.add(new Collections_InnerClass().new ItemList("Pencil",10,50));
		item.add(new Collections_InnerClass().new ItemList("WritingPad",5,500));

		System.out.println("List before sorting: ");
		for(ItemList i : item) {
			System.out.println(i);
		}
		
		item.sort((i1,i2)-> Double.compare(i1.getPrice(), i2.getPrice()));
		
		System.out.println("\nSorting based on price: ");
		for(ItemList i : item) {
			System.out.println(i);
		}
	}

}

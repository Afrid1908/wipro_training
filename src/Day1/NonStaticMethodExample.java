package Day1;



class Counter {
    int count = 0;                // instance variable
    public void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}

public class NonStaticMethodExample {

	 public static void main(String[] args) {
	        Counter c1 = new Counter();
	        Counter c2 = new Counter();
	        c1.increment();
	        c2.increment();
	        c2.increment();
	        System.out.println(c1.getCount());  // prints 1
	        System.out.println(c2.getCount());  // prints 2
	    }

}

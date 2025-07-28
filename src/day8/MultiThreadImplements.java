package day8;


class Runnable1 implements Runnable{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("MultiThreading in Java");
			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Runnable2 implements Runnable{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("Implementing Runnable");
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class MultiThreadImplements {
	public static void main(String[] args) {
		Runnable r1=new Runnable1();
		Runnable r2=new Runnable2();
				
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		
		t1.start();
		t2.start();

	}

}

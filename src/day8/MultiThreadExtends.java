package day8;

class Multi1 extends Thread{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("Java Programming");
			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Multi2 extends Thread{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("MultiThreading in Java");
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class MultiThreadExtends{
	
	public static void main(String[] args) {
		Multi1 m1 = new Multi1();
		Multi2 m2 = new Multi2();
		
		m1.start();
		try {
			Thread.sleep(10);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
			
		}
		m2.start();
	
	}
}

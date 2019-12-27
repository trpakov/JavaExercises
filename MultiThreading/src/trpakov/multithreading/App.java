package trpakov.multithreading;
import static java.lang.System.out;

public class App {

	static int counter = 0;
	
	static void increment() { counter++; }
	
	static void process() {
				
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
					for (int i = 0; i < 100; i++) {
						increment();
						out.println("Thread 1: " + counter);
					}			
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					increment();
					out.println("Thread 2: " + counter);
				}			
			}
		});
		
		t1.start();
		t2.start();
		
	}
	
	
	public static void main(String[] args) {
		//process();
		
//		Thread t1 = new Thread(new Runner1());
//		Thread t2 = new Thread(new Runner2());
//		t1.start();
//		t2.start();
		
		new A().start();
		new B().start();
		new C().start();
	}
}


class Runner1 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			out.println("Runner1: " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

class Runner2 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			out.println("Runner2: " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

class A extends Thread{
	@Override
	public void run(){
		for (int i = 0; i <= 5; i++) {
			out.println("\t From Thread A: i = " + i);
		}
		out.println("Exit from Thread A");
	}
}

class B extends Thread{
	@Override
	public void run() {
		for (int i = 0; i <= 5; i++) {
			out.println("\t From Thread B: i = " + i);
		}
		out.println("Exit from Thread B");
	}
	
}

class C extends Thread{
	@Override
	public void run() {
		for (int i = 0; i <= 5; i++) {
			out.println("\t From Thread C: i = " + i);
		}
		out.println("Exit from Thread C");
	}
}




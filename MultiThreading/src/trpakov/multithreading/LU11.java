package trpakov.multithreading;

import java.util.Arrays;

public class LU11 {
	public static void main(String[] args) throws InterruptedException {
		ArrayConstruction arrConstr = new ArrayConstruction();
        PrintingThread printingThr = new PrintingThread(arrConstr);
        SortingThread sortingThr = new SortingThread(arrConstr);
        arrConstr.create();
        arrConstr.print();
        System.out.println();
        System.out.println("After construction");

        sortingThr.start();
        //sortingThr.join();
        printingThr.start();
        
	}
}

class ArrayConstruction{
	int[] arr = new int[1500];
	
	public ArrayConstruction() {
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = i;
		}
	}
	
	void create(){
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100);
		}
		System.out.println("Creation Finished!");
	}
	
	 synchronized void print(){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

class PrintingThread extends Thread{
	ArrayConstruction arrConstr;
	
	public PrintingThread(ArrayConstruction arrC) {
		arrConstr = arrC;
	}
	
	@Override
	public void run() {
		arrConstr.print();
	}
}

class SortingThread extends Thread{
	ArrayConstruction arrConstr;
	
	public SortingThread(ArrayConstruction arrC) {
		arrConstr = arrC;
	}
	
	@Override
	public void run() {
		synchronized (arrConstr) {
			Arrays.sort(arrConstr.arr);
		}

	}
}

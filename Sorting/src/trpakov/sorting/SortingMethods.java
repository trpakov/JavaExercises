package trpakov.sorting;

import static java.lang.System.out;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;


public class SortingMethods {
	
	static final Random RANDOM = new Random();
	static final int[] FIBONACCI_NUMBERS = new int[100000];

	public static void main(String[] args) {
		int[] arr1 = {10, 80, 30, 90, 40, 50, 70};
		int[] arr2 = arr1.clone();
		int[] searchedArr = {1,1,1,5,5,7,8,13,16,17,22,22,22,26};
		printarr(arr1); //printarr(arr2);
		//quicksortLomuto(arr1, 0, arr1.length - 1); quicksortHoare(arr2, 0, arr2.length - 1);
		//mergesort(arr1, 0, arr1.length - 1);
		printarr(arr1); //printarr(arr2);
		
		//System.out.println(binarySearchIterative(searchedArr, 8));
		System.out.println(binarySearchRecursive(searchedArr, 0, searchedArr.length - 1, 26));

		int[] bigArray = new int[10000];
		for (int i = 0; i < bigArray.length; i++) {
			bigArray[i] = RANDOM.nextInt(1000000);
		}
		//printarr(bigArray);
		//System.out.println(FibonacciRecursionMemoization(9999));
		
		//variations3places();
		
//		int[] vals = {0,1,2};
//		do {
//			printarr(vals);
//		} while (nextC(5, vals));
		
//		int[] perms = {0,1,2};
//		do {
//			printarr(perms);
//		} while (nextP(perms));
		
		System.out.println(FindMaxDAC(arr1, 0, arr1.length - 1));
		System.out.println(FindMaxDAC(new int[]{1,4,2,8}, 0, 4));
		
		out.println(powDAC(3, 3));
		out.println(FibonacciRecursionMemoization(10000));
		out.println(fibonacciIterative(10000));
		
	}
	
	static void printarr(int[] arr) { System.out.println(Arrays.toString(arr)); }
	
	static void quicksortLomuto(int[] arr, int low, int high) {
		
		if (low < high) {
			
			int pi = partitionLomuto(arr, low, high); // partitioning index
			
			quicksortLomuto(arr, low, pi -1);
			quicksortLomuto(arr, pi + 1, high);
		}
	}
	
	static void quicksortHoare(int[] arr, int low, int high) {
	
		if (low < high) {
			
			int pi = partitionHoare(arr, low, high); // partitioning index
			
			quicksortHoare(arr, low, pi);
			quicksortHoare(arr, pi + 1, high);
		}
	}
	
	static int partitionLomuto(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		int i = low;
		
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				swap(arr, i, j);
				i++;
			}		
		}
		
		swap(arr, i, high);
		return i;
	}
	
	static int partitionHoare(int[] arr, int low, int high){
		
		int pivot = arr[low + (high - low)/2];
		int i = low - 1;
		int j = high + 1;
		
		while (true) {
			do {i++;} while (arr[i] < pivot);
			do {j--;} while (arr[j] > pivot);
			
			if( i >= j) return j;
			swap(arr, i, j);
		}
	}
	
	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	static void mergesort(int[] arr, int l, int r) {
		
		if (l < r) {
			int m = (l + r) / 2;
			
			mergesort(arr, l, m);
			mergesort(arr, m+1, r);
			
			merge(arr, l, m, r);
		}
	}
	
	static void merge(int[] arr, int l, int m, int r) {
		
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for (int i = 0; i < n1; i++) { L[i] = arr[l + i]; }
		for (int i = 0; i < n2; i++) { R[i] = arr[m + 1 + i]; }
		
		int i = 0, j = 0, k = l;
		
		while (i < n1 && j < n2) {
			
			if(L[i] <= R[j]) 
			{
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			
			k++;
		}
		
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	static int binarySearchIterative(int[] arr, int value) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] < value) start = mid + 1;
			else if(arr[mid] > value) end = mid - 1;
			else return arr[mid];
		}
		return -1;
	}
	
	static int binarySearchRecursive(int[] arr, int start, int end, int value) {
		int mid = start + (end - start)/2;
		
		if(start > end) return -1;
		else if (arr[mid] == value) return value;
		else if (arr[mid] > value) return binarySearchRecursive(arr, start, mid - 1, value);
		else return binarySearchRecursive(arr, mid + 1, end, value);
	}
	
	static int FibonacciRecursionMemoization(int n) {
		if(FIBONACCI_NUMBERS[n] == 0) {
			if(n < 2) FIBONACCI_NUMBERS[n] = 1;
			else FIBONACCI_NUMBERS[n] = FibonacciRecursionMemoization(n-1) + FibonacciRecursionMemoization(n-2);
		}
		
		return FIBONACCI_NUMBERS[n];
	}
	
	static int fibonacciRec(int n) {
		if (n < 2) return 1;
		
		return fibonacciRec(n-1) + fibonacciRec(n-2);
	}
	
	static BigDecimal fibonacciIterative(int n) {
		if (n < 2) return BigDecimal.ONE;
		
		BigDecimal n1 = BigDecimal.ONE;
		BigDecimal n2 = BigDecimal.ONE;
		
		for (int i = 2; i < n; i++) {
			BigDecimal sum = n1.add(n2);
			n1 = n2;
			n2 = sum;
		}
		
		return n2;
	}
	
	// Вариации с повторения
	
	static void variations3places() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int j2 = 0; j2 < 10; j2++) {
					System.out.println(i + "" + j + "" + j2);
				}
			}
		}
	}
	
	static boolean next(int n, int[] vals) {
		int k = vals.length;
		vals[k - 1]++;
		
		for(int i = k - 1; i > 0; i--) {
			if(vals[i] >= n) {
				vals[i] = 0;
				vals[i-1]++;
			}
		}
		return vals[0] < n;
	}
	
	// Комбинации
	
	static boolean nextC(int n, int[] vals) {
		vals[vals.length - 1]++;
		
		for(int i = vals.length-1; i > 0; i--) {
			if(vals[i] >= n - (vals.length - i) + 1) vals[i-1]++;
		}
		
		if(vals[0] > n - vals.length) return false;
		
		for(int i = 1; i < vals.length; i++) {
			if(vals[i] >= n - (vals.length -i) + 1) vals[i] = vals[i-1] + 1;
		}
		
		return true;
	}
	
	// Пермутации
	
	static boolean nextP(int[] vals) {
		int i = vals.length - 1;
		while (i > 0 && vals[i-1] >= vals[i]) i--;
		
		if(i <= 0) return false;
		
		int j = vals.length - 1;
		while(vals[j] <= vals[i-1]) j--;
		swap(vals, i-1, j);
		
		j = vals.length - 1;
		while(i < j) {
			swap(vals, i, j);
			i++;
			j--;
		}
		
		return true;		
	}
	
	static int FindMaxDAC(int[] a, int l, int r) {
		if (r-l == 1) return a[l];
		
		int m = (l+r)/2;
		
		int lMax = FindMaxDAC(a, l, m);
		int rMax = FindMaxDAC(a, m, r);
		
		System.out.println("Comparing " + lMax + " and " + rMax);
		return lMax > rMax ? lMax : rMax;
	}
	
	static double powDAC(double num, int power) {
		
		if(power == 0) return 1;
		
		if(power % 2 == 0) return powDAC(num * num, power/2);
		else return num * powDAC(num, power - 1);
	}

}



package com.example;
import java.util.Scanner;

public class NumOfDays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Въведете брой дни:");
		int referenceDay = 4;
		int days = sc.nextInt();
		System.out.printf("Ако днес е %s, то след %d дена ще бъде %s%n", printDay(referenceDay), days, getDay(days, referenceDay));
		sc.close();
		
//		double value = 5;
//		double power = 3.5;
//		System.out.printf("%.0f на сетепeн %.3f e %.3f%n", value, power, getPower(value, power));
//		float result = (float) getPower(3, 2);
//		System.out.println(result);
		
		final int seconds = 5000;
		int min = seconds / 60;
		int seconds1 = seconds % 60;
		int hours = min / 60;
		min = min % 60;
		int days1 = hours / 24;
		hours = hours % 24;
		
		System.out.println();
		System.out.printf("%d секунди са: %d дена, %d часа, %d минути и %d секунди", seconds, days1, hours, min, seconds1);
		
	}
	
	static String getDay(int days, int referenceDay){
		days = (days + referenceDay) % 7;				
		return printDay(days);  		
	}
	
	static String printDay(int day){
		String result = "";
		
		switch(day)
		{
			case 0: result = "Понеделник"; break;
			case 1: result = "Вторник"; break;
			case 2: result =  "Сряда";break;
			case 3: result = "Четвъртък"; break;
			case 4: result = "Петък"; break;
			case 5: result = "Събота"; break;
			case 6: result = "Неделя"; break;
		}
		
		return result;
	}
	
	static double getPower(double value, double power)
	{
		return Math.pow(value, power);
	}
}

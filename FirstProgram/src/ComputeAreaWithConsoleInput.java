import java.util.Scanner;

public class ComputeAreaWithConsoleInput {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		
		System.out.print("Enter a number for radius: ");
		double radius = inputScanner.nextDouble();
		
		double area = radius * radius * Math.PI;
		
		System.out.println("The area for the circle of radius " + radius + " is " + area);
	}
}

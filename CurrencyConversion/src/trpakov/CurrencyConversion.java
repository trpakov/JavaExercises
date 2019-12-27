package trpakov;
import java.util.InputMismatchException;
import java.util.Scanner;

class CurrencyConversion {

	public static void main(String[] args) {
		System.out.println("CURRENCY USD CONVERTOR");
		System.out.println("======================");
		
		for (int i = 1; i <= SupportedCurrencies.values().length; i++) {
			System.out.printf("(%d) %s%n", i, SupportedCurrencies.values()[i-1]);
		}
		
		System.out.println("(0) EXIT");
		System.out.println("======================");
		
		System.out.print("Select currency index:");
		
		Scanner sc = new java.util.Scanner(System.in);
		int selection;
				
		do {
			
			try{
				selection = sc.nextInt();
			
				if (selection > 7 || selection < 0) {
					System.out.printf("Please, enter a number between 0 and %d:", SupportedCurrencies.values().length);
					continue;
				}				
				else if (selection == 0) {
					System.out.println("APPLICATION ENDED BY USER");
					System.exit(0);
				}
		
			}
			catch(InputMismatchException e) {
				System.out.print("Please, enter a number:");
				sc.next();
				selection = -1;
			}
			
		} while (selection > 7 || selection < 0);
		
		var selectionName = SupportedCurrencies.values()[selection-1];
			
		//System.out.printf("You selected %d", selection);
		System.out.print("Please, enter the desired amount (0 to exit):");
		double amount;
		
		do {
			try {
				amount = sc.nextDouble();
				
				if (amount < 0) {
					System.out.print("Please, enter a positive number (0 to exit):");
					continue;
				}
				else if (amount == 0) {
					System.out.println("APPLICATION ENDED BY USER");
					System.exit(0);
				}
				
			} catch (InputMismatchException e) {
				System.out.print("Please, enter a valid amount (0 to exit):");
				sc.next();
				amount = -1;
			}
		} while (amount < 0);
	
		sc.close();
		
		double result = convertToUSD(selectionName, amount);
		printConversion(selectionName, amount, result);


	}
	
	enum SupportedCurrencies{
		BGN(0.557095),
		EURO(1.08975),
		GBP(1.22804),
		JPY(0.009249),
		RUB(0.01541),
		CHF(1.001336),
		RSD(0.009293);
		
		double constant;
		
		private SupportedCurrencies(double constant) {
			this.constant = constant;
			
		}
		
	}
		
	static double convertToUSD(SupportedCurrencies supportedCurrency, double amount) {
		return amount * supportedCurrency.constant;			
	}
	
	static void printConversion(SupportedCurrencies selectedCurrencyName, double amount, double result) {
		System.out.printf("%.2f %s is %.2f USD%n", amount, selectedCurrencyName, result);
	}
	
}

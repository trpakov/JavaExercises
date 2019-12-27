
public class EmployeeMain {

	public static void main(String[] args) {
		
		Employee person = new Lawyer(3);
		System.out.println(person.getSalary());
		System.out.println(person.getVacationForm());
		
		Lawyer lisa = new Lawyer(3);
		Secretary steve = new Secretary(2);			
		
		printInfo(lisa);
		printInfo(steve);
		
		Employee[] employees = {new Lawyer(3), new Secretary(2), new Marketer(4), new LegalSecretary(1)};
		
		for (int i = 0; i < employees.length; i++) {
			System.out.println("salary = " + employees[i].getSalary());
			System.out.println("vacation days = " + employees[i].getVacationDays());
			System.out.println();
		}
	}
	
	public static void printInfo(Employee emp1) {
		System.out.println("salary = " + emp1.getSalary());
		System.out.println("days = " + emp1.getVacationDays());
		System.out.println("form = " + emp1.getVacationForm());
		System.out.println();
	}

}

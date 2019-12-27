
public class Employee {
	
	private int years;
	
	public Employee(int years) {
		this.years = years;
	}

	public int getYears() {
		return years;
	}
	
	public int getHours() {
		return 40;
	}
	
	public double getSalary() {
		return 50000.0;
	}
	
	public int getVacationDays() {
		return 10 + getSeniorityBonus();
	}
	
	public int getSeniorityBonus() {
		return 2 * years;
	}
	
	public String getVacationForm() {
		return "yellow";
	}
}
